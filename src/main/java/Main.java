import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MissionFactory missionFactory = new MissionFactory();
        missionFactory.generateMissions();

        Mission[] missions = missionFactory.getMissions();

        boolean confirmLaunch = false;
        do {
            System.out.println("Pick a mission:");
            for (int i = 0; i < missions.length; i++) {
                System.out.println((i + 1) + ") " + missions[i]);
            }
            int choice = scan.nextInt();
            Mission chosenMission = missions[choice - 1];

            System.out.println("Execute the mission at night?");
            System.out.println("1) Yes\n2) No");
            int nightConfig = scan.nextInt();
            chosenMission.setIsNight(nightConfig == 1);

            System.out.println("How many bombers do you want to assign?");
            int numBombers = scan.nextInt();
            chosenMission.setNumBombers(numBombers);

            System.out.println("Here are the mission details:\n" + chosenMission);
            System.out.println("Confirm launch?\n1) Yes\n2) No");
            int userConfirm = scan.nextInt();
            confirmLaunch = userConfirm == 1;
        } while(!confirmLaunch);

        System.out.println("Godspeed men!");

        scan.close();
    }
}
