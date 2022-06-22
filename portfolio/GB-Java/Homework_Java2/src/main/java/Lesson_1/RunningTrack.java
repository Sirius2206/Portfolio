package Lesson_1;

public class RunningTrack implements Obstacle{
    private int distance;

    public RunningTrack(int distance){
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
