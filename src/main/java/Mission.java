public class Mission {
    private final String name;
    private final int numSteps;
    private boolean isNight = false;
    private double maxReward;
    private final double baseRisk;
    private double actualRisk;
    private int numBombers;

    public Mission(String name, int numSteps, double maxReward, double baseRisk) {
        this.name = name;
        this.numSteps = numSteps;
        this.maxReward = maxReward;
        this.baseRisk = baseRisk;
    }

    public void setIsNight(boolean isNight) {
        this.isNight = isNight;
    }

    public void setMaxReward(double maxReward) {
        this.maxReward = maxReward;
    }

    public void setNumBombers(int numBombers) {
        this.numBombers = numBombers;
    }

    public void setActualRisk(double actualRisk) {
        this.actualRisk = actualRisk;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public boolean getIsNight() {
        return isNight;
    }

    public double getMaxReward() {
        return maxReward;
    }

    public double getBaseRisk() {
        return baseRisk;
    }

    public double getActualRisk() {
        return actualRisk;
    }

    public int getNumBombers() {
        return numBombers;
    }

    public String getBriefing() {
        return "'" + name + "':" +
                "\n\tnumSteps: " + numSteps +
                "\n\tisNight: " + isNight +
                "\n\tmaxReward: " + maxReward +
                "\n\tbaseRisk: " + baseRisk +
                "\n\tactualRisk: " + actualRisk +
                "\n\tnumBombers: " + numBombers;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                ", numSteps=" + numSteps +
                ", isNight=" + isNight +
                ", maxReward=" + maxReward +
                ", baseRisk=" + baseRisk;
    }
}
