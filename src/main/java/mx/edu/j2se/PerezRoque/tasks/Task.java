package mx.edu.j2se.PerezRoque.tasks;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.Objects;

/**
 *  In this class are declare all the tasks,
 *  which is the main function of the application. Here are the
 *  name, the time, the status and more details of the task.
 * @version 1.0 17 feb 2021
 */
public class Task {
    private String title;       //reference of the task
    private LocalDateTime time;           //start time of non repetitive tasks
    private LocalDateTime start;          //start time of repetitive tasks
    private LocalDateTime end;            //end time of repetitive tasks
    private LocalDateTime interval;       //time between each task for repetitive ones
    private boolean active;     //status of the task
    private boolean repeat;     //define if the task is going to be repeat

    /**
     * Here are set the time and the title of the task, but this task
     * is going to be repeated only ones (non repetitive)
     *
     * @param title is the value to set the reference
     * @param time is the value to set the star time
     */
    public Task (String title, LocalDateTime time) throws IllegalArgumentException{
        if (time.getYear() <= 0) {
            throw new IllegalArgumentException(
                    "Year should not be negative or zero"
            );
        }
        if(time.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException(
                    "Time should be after now"
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
    public Task(String title, LocalDateTime start, LocalDateTime end, LocalDateTime interval) throws IllegalArgumentException{
        if (end.isBefore(start)){
            throw new IllegalArgumentException(
                    "End time should be greater than start time"
            );
        }
        if (end.getYear()<= 0 || start.getYear()<= 0){
            throw new IllegalArgumentException(
                    "Year should not be negative or zero"
            );
        }
        if (start.isBefore(LocalDateTime.now()) || end.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Time should be after now");
        }
        //falata la excepcion para que el intervalo no sea Zero
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

    public LocalDateTime getTime(){
        return (repeat ? start : time);
    }

    /**
     * this method change the time of the task and the status to
     * non repetitive task if it is a repetitive one
     * @param time the start time of the task
     */
    public void setTime(LocalDateTime time)throws IllegalArgumentException{
        if(time.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException(
                    "Time should be after now"
            );
        }
        if (time.getYear() <= 0) {
            throw new IllegalArgumentException(
                    "Year should not be negative or zero"
            );
        }
        if (repeat){
            repeat = false;
        }
        LocalDateTime new_time = time;
        this.time = new_time;
        this.start = null;
        this.end = null;
        this.interval = null;
    }

    public LocalDateTime getStartTime(){
        return (!repeat ? time : start);
    }

    public LocalDateTime getEndTime(){
        return (!repeat ? time : end);
    }

    public LocalDateTime getRepeatInterval(){
        return (!repeat ? null : interval);
    }

    /**
     * if the task is a non-repetitive one, it should become repetitive.
     * Set the value of the parameters that are missing.
     * @param start start time of the task.
     * @param end the end time of the task.
     * @param interval time between each repetition.
     */
    public void setTime(LocalDateTime start, LocalDateTime end, LocalDateTime interval) throws IllegalArgumentException {
        if ((start.isBefore(LocalDateTime.now())) || (end.isBefore(LocalDateTime.now()))){
            throw new IllegalArgumentException(
                    "Time should be after now"
            );
        }
        if (end.isBefore(start)){
            throw new IllegalArgumentException(
                    "End time should be greater than start time"
            );
        }
        if (end.getYear()<= 0 || start.getYear()<= 0){
            throw new IllegalArgumentException(
                    "year should not be negative or zero"
            );
        }
        //is missing interval zero exception
        if (!repeat){
            repeat = true;
        }
        LocalDateTime new_start = start;
        LocalDateTime new_end = end;
        LocalDateTime new_interval = interval;

        this.time = null;
        this.start = new_start;
        this.end = new_end;
        this.interval = new_interval;
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
    public LocalDateTime nextTimeAfter(LocalDateTime current){
        if (active && repeat && (current.isBefore(end) )){
            LocalDateTime execution = start;
            while( current.isAfter(execution)){
                execution = execution.plusNanos(interval.getNano());
                execution = execution.plusSeconds(interval.getSecond());
                execution = execution.plusMinutes(interval.getMinute());
                execution = execution.plusHours(interval.getHour());
                //interval have not correct function
                //execution = execution.plusDays(interval.getDayOfMonth());
                //execution = execution.plusMonths(interval.getMonthValue());
                //execution = execution.plusYears(interval.getYear());
            }
            return execution;
        }else if (active && !repeat && current.isBefore(time)) {
            return time;
        }else{
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return time == task.time && start == task.start && end == task.end && interval == task.interval && repeat == task.repeat && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, repeat);
    }

    @Override
    public String toString() {
        if(repeat){
            return "Task{" +
                    "title='" + title + '\'' +
                    ", start=" + start +
                    ", end=" + end +
                    ", interval=" + interval +
                    ", active=" + active +
                    ", repeat=" + true +
                    '}';
        }else{
            return "Task{" +
                    "title='" + title + '\'' +
                    ", time=" + time +
                    ", active=" + active +
                    ", repeat=" + false +
                    '}';
        }
    }

    @Override
    public Task clone(){
        return this;
    }

}
