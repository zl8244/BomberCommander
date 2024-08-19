public class Main {
    public static void main(String[] args) {
        MissionFactory missionFactory = new MissionFactory();
        missionFactory.generateMissions();

        Mission[] missions = missionFactory.getMissions();
        for(Mission m : missions) {
            System.out.println(m);
        }
    }
}
