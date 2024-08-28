import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BomberBase bomberBase = new BomberBase();
        bomberBase.generateMissions();
        Mission[] missions = bomberBase.getMissions();

        boolean confirmLaunch;
        Mission chosenMission;
        do {
            System.out.println("Pick a mission:");
            for (int i = 0; i < missions.length; i++) {
                System.out.println((i + 1) + ") " + missions[i]);
            }
            int choice = scan.nextInt();
            chosenMission = missions[choice - 1];

            System.out.println("Execute the mission at night?");
            System.out.println("1) Yes\n2) No");
            int nightConfig = scan.nextInt();
            chosenMission.setIsNight(nightConfig == 1);

            System.out.println("How many bombers do you want to assign?");
            int numBombers = scan.nextInt();
            chosenMission.setNumBombers(numBombers);

            double risk = chosenMission.getBaseRisk();

            // Risk is halved if mission is taken at night
            // But so is max possible reward (bombs less accurate so less reward)
            if(chosenMission.getIsNight()) {
                risk = risk * 0.5;
                double currentMaxReward = chosenMission.getMaxReward();
                double nightMaxReward = currentMaxReward / 2.0;
                chosenMission.setMaxReward(Utils.nearestDivisibleByFive(nightMaxReward));
            }

            // Every 3 bombers contributes to a flat 0.05 decrease in risk
            int numBombersAssigned = chosenMission.getNumBombers();
            risk = risk - (Utils.round(numBombersAssigned/3.0,0) * 0.05);

            // 0.05 is bare minimum risk after modifiers have been applied
            // Can't negate risk entirely
            // That'd be like saying no planes have ever crashed due to non-hostile actions
            if(risk < 0.05) {
                risk = 0.05;
            }

            chosenMission.setActualRisk(Utils.round(risk, 2));

            System.out.println("Here are the mission details:\n" + chosenMission.getBriefing());
            System.out.println("Confirm launch?\n1) Yes\n2) No");
            int userConfirm = scan.nextInt();
            confirmLaunch = userConfirm == 1;
        } while(!confirmLaunch);

        System.out.println("Aircraft launch!");

        int bombersReturned = chosenMission.getNumBombers();
        Random rand = new Random();
        ArrayList<MissionEvent> missionEvents = new ArrayList<>();
        for(int i = 1; i < chosenMission.getNumSteps()+1; i++) {
            double maxRand = 0;
            double minRand = 1;
            // Make numBombers number of dice rolls and get the max and min rolls
            for(int j = 0; j < chosenMission.getNumBombers(); j++) {
                double num = rand.nextDouble();
                maxRand = Math.max(maxRand, num);
                minRand = Math.min(minRand, num);
            }
            /*
            Get the difference of the max and min
            If the range is within the risk, then the event triggers
            i.e.
            Range: |----------------------------| 0.46
            Risk:  |---------------------------------------------| 0.8
            The range can fit in the risk so the event triggers
            */
            double randNum = maxRand - minRand;
            if(randNum < chosenMission.getActualRisk() && bombersReturned > 0) {
                missionEvents.add(new MissionEvent(i,1));
                bombersReturned--;
            }
        }

        for(MissionEvent event : missionEvents) {
            System.out.println(event);
        }

        System.out.println(bombersReturned + " bombers returned.");

        // Calculate actual reward received based on how many bombers returned
        double actualReward = chosenMission.getMaxReward();
        actualReward = actualReward * ((double)bombersReturned / chosenMission.getNumBombers());
        actualReward = Utils.round(actualReward, 0);
        actualReward = Utils.nearestDivisibleByFive(actualReward);

        System.out.println(actualReward + " reward has been granted.");

        scan.close();
    }
}
