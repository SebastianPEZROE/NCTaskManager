package mx.edu.j2se.PerezRoque.tasks;

/**
 *  In this class are declare all the tasks,
 *  which is the main function of the application. Here are the
 *  name, the time, the status and more details of the task.
 * @version 1.0 17 feb 2021
 */
public class Task {
    private String title;       //reference of the task
    private int time;           //start time of non repetitive tasks
    private int start;          //start time of repetitive tasks
    private int end;            //end time of repetitive tasks
    private int interval;       //time between each task for repetitive ones
    private boolean active;     //status of the task
    private boolean repeat;     //define if the task is going to be repeat

    /**
     * Here are set the time and the title of the task, but this task
     * is going to be repeated only ones (non repetitive)
     *
     * @param title is the value to set the reference
     * @param time is the value to set the star time
     */
    public Task (String title, int time) throws IllegalArgumentException{
        if (time < 0) {
            throw new IllegalArgumentException(
                    "Time should not be negative"
            );
        }
        this.title = title;
        this.time = time;
        active = false;
        repeat = false;
    }

    /**
     * Constructs an inactive task to run within the specified
     * time range (including the start and the end time) with
     * the set repetition interval and with a given name.
     * @param title is the value to set the reference
     * @param start is the value to set the star time
     * @param end is the value to set the end time
     * @param interval time between each task
     */
    public Task(String title, int start, int end, int interval) throws IllegalArgumentException{
        if (start<0 || end< 0){
            throw new IllegalArgumentException("time should not be negative");
        }
        if (end < start){
            throw new IllegalArgumentException(
                    "End time should be greater than start time"
            );
        }
        if (interval <= 0){
            throw new IllegalArgumentException(
                    "Interval should not be zero neither negative"
            );
        }
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        active = false;
        repeat = true;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean isActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public int getTime(){
        return (repeat ? start : time);
    }

    /**
     * this method change the time of the task and the status to
     * non repetitive task if it is a repetitive one
     * @param time the start time of the task
     */
    public void setTime(int time)throws IllegalArgumentException{
        if(time < 0){
            throw new IllegalArgumentException(
                    "time should not be negative"
            );
        }
        if (repeat){
            repeat = false;
        }
        this.time = time;
    }

    public int getStartTime(){
        return (!repeat ? time : start);
    }

    public int getEndTime(){
        return (!repeat ? time : end);
    }

    public int getRepeatInterval(){
        return (!repeat ? 0 : interval);
    }

    /**
     * if the task is a non-repetitive one, it should become repetitive.
     * Set the value of the parameters that are missing.
     * @param start start time of the task.
     * @param end the end time of the task.
     * @param interval time between each repetition.
     */
    public void setTime(int start, int end, int interval) throws IllegalArgumentException {
        if ((start < 0) || (end < 0)){
            throw new IllegalArgumentException(
                    "Time should not be negative"
            );
        }
        if (end < start){
            throw new IllegalArgumentException(
                    "End time should be greater than start time"
            );
        }
        if (interval <=0 ){
            throw new IllegalArgumentException(
                    "Interval should not be zero neither negative"
            );
        }
        if (!repeat){
            repeat = true;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public boolean isRepeated(){
        return repeat;
    }

    /**
     * returns the next start time of the task execution after
     * the current time. If after the specified time the task
     * is not executed anymore, the method must return -1.
     * @param current current time.
     * @return the start time of the task, or -1 if the task is not executed.
     */
    public int nextTimeAfter(int current){
        if (repeat && (current <= end) && ((end-current) > interval) ){
            int execution = start;
            while(current > execution){
                execution += interval;
            }
            return execution;
        }else if (!repeat && current <= time ) {
            return time;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", repeat=" + repeat +
                '}';
    }
}
