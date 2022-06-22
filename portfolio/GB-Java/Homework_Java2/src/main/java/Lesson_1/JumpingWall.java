package Lesson_1;

public class JumpingWall implements Obstacle{
    private int height;

    public JumpingWall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
