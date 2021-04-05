package mx.edu.j2se.PerezRoque.tasks;

import java.util.Iterator;

/**
 * in this class are the main functions of the tasks list
 */
abstract class AbstractTaskList implements Iterable<Task>{



    protected abstract void add(Task task);
    protected abstract boolean remove(Task task);
    protected abstract int size();
    protected abstract Task getTask(int index);
    protected abstract AbstractTaskList incoming(int from, int to );
    public abstract Iterator<Task> iterator();/*{
        return new itr();
    }

    private static class itr implements Iterator<Task>{
        public int cursor = 0;
        public int previous = -1;

        @Override
        public boolean hasNext() {
            return (getTask(cursor) != null);
        }

        @Override
        public Task next() {
            previous = cursor;
            Task output =  getTask(previous);
            cursor += 1;
            return output;
        }
    }*/
    public abstract AbstractTaskList cloning();
}
