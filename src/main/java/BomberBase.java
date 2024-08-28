public class BomberBase {
    private int numBombers;
    private double credits;
    private MissionFactory missionFactory = new MissionFactory();
    private Mission[] missions = new Mission[3];

    public BomberBase() {
        numBombers = 50;
        credits = 100.0;
    }

    public BomberBase(int numBombers, double credits) {
        this.numBombers = numBombers;
        this.credits = credits;
    }

    public int getNumBombers() {
        return numBombers;
    }

    public double getCredits() {
        return credits;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void generateMissions() {
        missionFactory.generateMissions();
        missions = missionFactory.getMissions();
    }
}
