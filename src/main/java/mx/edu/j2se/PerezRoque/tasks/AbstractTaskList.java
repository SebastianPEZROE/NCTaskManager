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

}
