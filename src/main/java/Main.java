import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MissionFactory missionFactory = new MissionFactory();
        missionFactory.generateMissions();

        Mission[] missions = missionFactory.getMissions();

        System.out.println("Pick a mission:");
        for(int i = 0; i < missions.length; i++) {
            System.out.println((i+1) + ") " + missions[i]);
        }
        int choice = scan.nextInt();
        Mission chosenMission = missions[choice-1];
        System.out.println("Execute the mission at night?");
        System.out.println("1) Yes\n2) No");
        int nightConfig = scan.nextInt();
        chosenMission.setIsNight(nightConfig == 1);
        System.out.println("Here are the mission details:\n" + chosenMission);
        scan.close();
    }
}
