package Lesson_1;

public class Human implements Participant {
    private String name;
    private int runningDistance;
    private int jumpHeight;
    private boolean success = true;

    public Human(String name, int runningDistance, int jumpHeight) {
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
        System.out.println(this.name + " делает бег на месте. Общепримиряющий");
    }

    public void running(RunningTrack rt){
        if(!success) return;
        if (rt.getDistance() <= runningDistance){
            System.out.println(this.name + " побежал.");
            this.runningDistance -= rt.getDistance();
        }else {
            System.out.println(this.name + " выдохся и не добежал.");
            this.success = false;
        }
    }

    public void jumping(){ System.out.println(this.name + " разминается прыжками.");   }
    public void jumping(JumpingWall jw){
        if(!success) return;
        if (jw.getHeight() <= jumpHeight){
            System.out.println(this.name + " ловкими движениями перемахнул через стену.");
        }else {
            System.out.println(this.name + " не смог перепрыгнуть стену.");
            this.success = false;
        }
    }
}
