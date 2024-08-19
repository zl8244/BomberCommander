public class Mission {
    String name;
    int numSteps;
    boolean isNight;
    int reward;
    double risk;

    public Mission(String name) {
        this.name = name;
        numSteps = 100;
        isNight = false;
        reward = 100;
        risk = 50.0;
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
