package mx.edu.j2se.PerezRoque.tasks;

import javax.lang.model.type.NullType;

/**
 * In this class are stored the tasks in arrays
 * and have methods to add more task, remove task from the list,
 * to know which task are and how many are they, as well as,
 * a list that store tasks in a range of time. *
 */
public class ArrayTaskList {
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

    public Task getTask(int index) throws IndexOutOfBoundsException{
        try {
            return taskList[index];
        }catch (Exception e){
            throw new IndexOutOfBoundsException(
                    "Index should not be negative neither greater than the number of tasks that contains, please"
            );
        }
    }

    /**
     * This method returns a subset of tasks that are scheduled
     * for execution at least once after the "from" time, and
     * not later than the "to" time.
     *
     * @param from where starts the range of time.
     * @param to where the range of time ends.
     * @return a list of taks that are in the range of time.
     */
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList coming_soon = new ArrayTaskList();
        for(int i = 0; i< taskList.length;i++){
            if (taskList[i].isActive()){
                if (taskList[i].nextTimeAfter(from) >= from && taskList[i].nextTimeAfter(from) <= to){
                    coming_soon.add(taskList[i]);
                }
            }
        }
        return coming_soon;
    }

}
