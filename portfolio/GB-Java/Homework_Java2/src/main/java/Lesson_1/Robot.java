package Lesson_1;

public class Robot implements Participant {
    private String name;
    private int runningDistance;
    private int jumpHeight;
    private boolean success = true;

    public Robot(String name, int runningDistance, int jumpHeight) {
        this.name = name;
        this.runningDistance = Math.max(runningDistance, 0);
        this.jumpHeight = Math.max(jumpHeight, 0);

    }

    public void overcome(Obstacle obstacle){
        if (obstacle instanceof JumpingWall){
            System.out.println(this.name + " пытается перепрыгнуть препятствие высотой " + ((JumpingWall) obstacle).getHeight());
            this.jumping((JumpingWall) obstacle);
        }else{
            System.out.println(this.name + " пытается пробежать трассу длиной " + ((RunningTrack) obstacle).getDistance());
            this.running((RunningTrack) obstacle);
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public void running(){
        System.out.println(this.name + " не нуждается в разминке.");
    }

    public void running(RunningTrack rt){
        if(!success) return;
        if (rt.getDistance() <= runningDistance){
            System.out.println(this.name + " от Boston Dynamics побежал.");
            this.runningDistance -= rt.getDistance();
        }else {
            System.out.println(this.name + " перегорел.");
            this.success = false;
        }
    }

    public void jumping(){ System.out.println(this.name + " не нуждается в разминке.");}

    public void jumping(JumpingWall jw){
        if(!success) return;
        if (jw.getHeight() <= jumpHeight){
            System.out.println(this.name + " смог перепрыгнуть через препятствие.");
        }else {
            System.out.println(this.name + " прыгает. Но что-то пошло не так и он падает.");
            this.success = false;
        }
    }
}
