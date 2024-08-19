import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MissionFactory missionFactory = new MissionFactory();
        missionFactory.generateMissions();

        Mission[] missions = missionFactory.getMissions();

        int choice;
        while(true) {
            try{
                System.out.println("Pick a mission:");
                for(int i = 0; i < missions.length; i++) {
                    System.out.println((i+1) + ") " + missions[i]);
                }
                choice = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                scan.next();
            }
        }
        System.out.println("You chose: " + choice);
        System.out.println(missions[choice-1]);
        scan.close();
    }
}
