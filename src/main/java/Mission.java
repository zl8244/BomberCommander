public class Mission {
    private final String name;
    private final int numSteps;
    private boolean isNight = false;
    private final double reward;
    private final double baseRisk;
    private int numBombers;

    public Mission(String name, int numSteps, double reward, double baseRisk) {
        this.name = name;
        this.numSteps = numSteps;
        this.reward = reward;
        this.baseRisk = baseRisk;
    }

    public void setIsNight(boolean isNight) {
        this.isNight = isNight;
    }

    public void setNumBombers(int numBombers) {
        this.numBombers = numBombers;
    }

    public int getNumBombers() {
        return numBombers;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                ", numSteps=" + numSteps +
                ", isNight=" + isNight +
                ", reward=" + reward +
                ", baseRisk=" + baseRisk +
                ", numBombers=" + numBombers;
    }
}
