import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MissionFactory {
    private int numMissions = 3;
    private final Mission[] missions;
    private int minNumSteps = 100;
    private int maxNumSteps = 300;
    private double minRisk = 0.15;
    private double maxRisk = 0.95;
    private int numSteps;
    private double baseRisk;

    public MissionFactory() {
        missions = new Mission[numMissions];
    }

    public MissionFactory(int numMissions) {
        this.numMissions = numMissions;
        missions = new Mission[this.numMissions];
    }

    public MissionFactory(int numMissions, int minNumSteps, int maxNumSteps,
                          double minRisk, double maxRisk) {
        this.numMissions = numMissions;
        this.minNumSteps = minNumSteps;
        this.maxNumSteps = maxNumSteps;
        this.minRisk = minRisk;
        this.maxRisk = maxRisk;
        missions = new Mission[this.numMissions];
    }

    public Mission[] getMissions() {
        return missions;
    }

    private double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double nearestDivisibleByFive(double value) {
        if(value % 5 == 0) return value;

        int countUp = 0;
        double valueUp = value;
        int countDown = 0;
        double valueDown = value;

        do{
            valueUp++;
            countUp++;
        } while(valueUp % 5 != 0);

        do {
            valueDown--;
            countDown++;
        } while(valueDown % 5 != 0);

        if(countUp <= countDown) return valueUp;

        return valueDown;
    }

    private int generateRandomNumSteps() {
        Random randNumSteps = new Random();
        maxNumSteps += 1;
        return randNumSteps.nextInt(maxNumSteps-minNumSteps)+minNumSteps;
    }

    private double generateRandomRisk() {
        Random randRisk = new Random();
        double temp = maxRisk * 100;
        temp += 1;
        maxRisk = temp/100;
        double value = randRisk.nextDouble(maxRisk-minRisk)+minRisk;
        return round(value, 2);
    }

    private double generateReward() {
        double value = numSteps * (1+baseRisk);
        return round(value, 0);
    }

    public void generateMissions() {
        for(int i = 0; i < numMissions; i++) {
            String name = "Mission " + (i+1);
            numSteps = generateRandomNumSteps();
            baseRisk = generateRandomRisk();
            double maxReward = generateReward();

            numSteps = (int)nearestDivisibleByFive(numSteps);
            maxReward = nearestDivisibleByFive(maxReward);

            missions[i] = new Mission(name, numSteps, maxReward, baseRisk);
        }
    }
}
