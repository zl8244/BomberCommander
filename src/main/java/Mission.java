import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Mission {
    String name;
    int minNumSteps = 10;
    int maxNumSteps = 100;
    double minRisk = 0.25;
    double maxRisk = 0.8;
    int numSteps;
    boolean isNight;
    double reward;
    double risk;

    public Mission(String name) {
        this.name = name;
        isNight = false;
        generateRandomNumSteps();
        generateRandomRisk();
        generateReward();
    }

    public Mission(String name, int minNumSteps, int maxNumSteps,
                   double minRisk, double maxRisk) {
        this.name = name;
        this.minNumSteps = minNumSteps;
        this.maxNumSteps = maxNumSteps;
        this.minRisk = minRisk;
        this.maxRisk = maxRisk;
        isNight = false;
        generateRandomNumSteps();
        generateRandomRisk();
        generateReward();
    }

    private double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void generateRandomNumSteps() {
        Random randNumSteps = new Random();
        maxNumSteps += 1;
        numSteps = randNumSteps.nextInt(maxNumSteps-minNumSteps)+minNumSteps;
    }

    private void generateRandomRisk() {
        Random randRisk = new Random();
        double temp = maxRisk * 100;
        temp += 1;
        maxRisk = temp/100;
        double value = randRisk.nextDouble(maxRisk-minRisk)+minRisk;
        risk = round(value, 2);
    }

    private void generateReward() {
        double value = numSteps * (1+risk);
        reward = round(value, 0);
    }

    public void setIsNight(boolean isNight) {
        this.isNight = isNight;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "name='" + name + '\'' +
                ", numSteps=" + numSteps +
                ", isNight=" + isNight +
                ", reward=" + reward +
                ", risk=" + risk +
                '}';
    }
}
