package mx.edu.j2se.PerezRoque.tasks;

/**
 * in this class are the main functions of the tasks list
 */
abstract class AbstractTaskList {

    protected abstract void add(Task task);
    protected abstract boolean remove(Task task);
    protected abstract int size();
    protected abstract Task getTask(int index);
    protected abstract AbstractTaskList incoming(int from, int to );

}
