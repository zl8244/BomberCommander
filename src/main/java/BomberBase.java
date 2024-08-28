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

    public void subBombers(int bombers) {
        numBombers -= bombers;
    }

    public void addBombers(int bombers) {
        numBombers += bombers;
    }

    public void addCredits(double reward) {
        credits += reward;
    }

    public void subCredits(double cred) {
        credits -= cred;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void generateMissions() {
        missionFactory.generateMissions();
        missions = missionFactory.getMissions();
    }
}
