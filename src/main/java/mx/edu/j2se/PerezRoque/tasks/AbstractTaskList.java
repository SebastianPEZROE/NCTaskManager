package mx.edu.j2se.PerezRoque.tasks;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * in this class are the main functions of the tasks list
 */
abstract class AbstractTaskList implements Iterable<Task>{

    protected abstract void add(Task task);
    protected abstract boolean remove(Task task);
    protected abstract int size();
    protected abstract Task getTask(int index);
    public abstract Iterator<Task> iterator();
    public abstract AbstractTaskList cloning();
    public abstract Stream<Task> getStream();

    /**
     * this methods return a subset of task that are
     * schedule in a range of time.
     * @param from the start time of the range
     * @param to the end time of the range
     * @return an AbstractTaskList of the same type of instance.
     */
    public final AbstractTaskList incoming(int from, int to){
        AbstractTaskList coming_soon = (this instanceof ArrayTaskList) ?
                new ArrayTaskList() :
                new LinkedTaskList();
        this.getStream().
                filter(Task::isActive).
                filter(element -> (element.nextTimeAfter(from) >= from && element.nextTimeAfter(from) <= to)).
                forEach(coming_soon::add);
        return coming_soon;
    }

}
