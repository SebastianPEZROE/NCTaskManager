package mx.edu.j2se.PerezRoque.tasks;

import java.lang.reflect.Array;

/**
 * this class creates task list, depending
 * on the chosen way.
 */
public class TaskListFactory {
    private static AbstractTaskList taskList;

    public static AbstractTaskList createTaskList(ListTypes.types type){
        if (type == ListTypes.types.ARRAY){
            taskList = new ArrayTaskList();
        }else if(type == ListTypes.types.LINKED){
            taskList = new LinkedTaskList();
        }
        return taskList;
    }

}
