public class Mission {
    private final String name;
    private final int numSteps;
    private boolean isNight = false;
    private final double reward;
    private final double baseRisk;

    public Mission(String name, int numSteps, double reward, double baseRisk) {
        this.name = name;
        this.numSteps = numSteps;
        this.reward = reward;
        this.baseRisk = baseRisk;
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
                ", baseRisk=" + baseRisk +
                '}';
    }
}
