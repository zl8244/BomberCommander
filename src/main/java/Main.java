public class Main {
    public static void main(String[] args) {
        Mission[] missions = new Mission[3];
        for(int i = 0; i < missions.length; i++) {
            String name = "Mission" + i;
            missions[i] = new Mission(name);
        }

        for(Mission m : missions) {
            System.out.println(m);
        }
    }
}
