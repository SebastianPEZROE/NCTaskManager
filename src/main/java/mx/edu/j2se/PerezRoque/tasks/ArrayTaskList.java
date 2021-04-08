package mx.edu.j2se.PerezRoque.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * In this class are stored the tasks in arrays
 * and have methods to add more task, remove task from the list,
 * to know which task are and how many are they, as well as,
 * a list that store tasks in a range of time. *
 */
public class ArrayTaskList extends AbstractTaskList{
    private int elements = 0;
    private Task[] taskList = new Task[elements];
    private Task[] listSize;

    /**
     * Add a task object into a list of task.
     * Uses another array to manage the size of the array
     * then copy all the elements to the new array and
     * use the direction to point the list of task
     * then set the task at the end of the array.
     * @param task is the object to be stored
     */
    public void add(Task task) throws NullPointerException {
        if (task == null){
            throw new NullPointerException(
                    "Task object should not be null"
            );
        }
        elements++;
        listSize = new Task[elements];
        System.arraycopy(taskList,0,listSize,0,taskList.length);
        taskList = listSize;
        taskList[elements-1] = task;
    }

    /**
     * Remove task if are in task list.
     * First, looks if the task is in the array then
     * set the size of the new array, after this,
     * copy all the element in the new array and point
     * to the task list.
     * if the task wasn't there return false.
     *
     * @param task is the task the be removed.
     * @return true if the task was remove.
     */
    public boolean remove(Task task){
        listSize = new Task[0];
        for (int i= 0; i< taskList.length;i++) {
            if (task == taskList[i]){
                elements--;
                listSize = new Task[elements];
                System.arraycopy(taskList,0,listSize,0,i);
                System.arraycopy(taskList,i+1,listSize,i,taskList.length-i-1);
                taskList = listSize;
                return true;
            }
        }
        return false;
    }

    public int size(){
        return taskList.length;
    }

    public Task getTask(int index) {
        try {
            return taskList[index];
        }catch (Exception e){
            throw new IndexOutOfBoundsException(
                    "Index should not be negative neither greater than the number of tasks that contains, please"
            );
        }
    }

    @Override
    public Iterator<Task> iterator(){
        return new itr();
    }

    private class itr implements Iterator<Task>{
        private int cursor = 0;
        private int previous = -1;

        @Override
        public boolean hasNext() {
            return (cursor < elements);
        }

        @Override
        public Task next() {
            previous = cursor;
            cursor ++;
            return (cursor <= elements ? taskList[previous] : null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList tasks = (ArrayTaskList) o;
        return elements == tasks.elements && Arrays.equals(taskList, tasks.taskList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(elements);
        result = 31 * result + Arrays.hashCode(taskList);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "elements=" + elements +
                ", taskList=" + Arrays.toString(taskList) +
                '}';
    }

    @Override
    public ArrayTaskList cloning() {
        ArrayTaskList c = new ArrayTaskList();
        for(Task t: taskList){
            c.add(t);
        }
        return c;
    }

    @Override
    public Stream<Task> getStream(){
        return Stream.of(taskList);
    }

}
