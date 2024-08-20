public class MissionEvent {
    private final int stepOccurred;
    private final int bombersAffected;

    public MissionEvent(int stepOccurred, int bombersAffected) {
        this.stepOccurred = stepOccurred;
        this.bombersAffected = bombersAffected;
    }

    public int getBombersAffected() {
        return bombersAffected;
    }

    @Override
    public String toString() {
        if (bombersAffected != 0) {
            return "At step " + stepOccurred + " something happened." +
                    "\n" + bombersAffected + " bombers were downed.";
        }

        return "At step " + stepOccurred + " something happened." +
                "\nNo bombers were downed.";
    }
}
