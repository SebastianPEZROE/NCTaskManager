package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * here are tested the methods that were implemented in the AbstractTaskList
 */
public class AbstractTaskListTest {

    @Test
    public void incomingWithArrayTest() throws Exception{
        Task t1 = new Task("t1", 20);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        AbstractTaskList aa = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        aa.add(t1);
        aa.add(t2);
        aa.add(t3);
        aa.add(t2);
        t1.setActive(true);
        t2.setActive(true);
        t3.setActive(true);
        AbstractTaskList aa2 = aa.incoming(15,25);
        AbstractTaskList aa3 = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        aa3.add(t1);
        aa3.add(t2);
        aa3.add(t2);
        Assert.assertEquals(aa2,aa3);
        aa2 = aa.incoming(16,18);
        aa3.remove(t1);
        Assert.assertEquals(aa2,aa3);
    }

    @Test
    public void incomingWithLinkedTest() throws Exception{
        Task t1 = new Task("t1", 20);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        AbstractTaskList aa = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        aa.add(t1);
        aa.add(t2);
        aa.add(t3);
        aa.add(t2);
        t1.setActive(true);
        t2.setActive(true);
        t3.setActive(true);
        AbstractTaskList aa2 = aa.incoming(15,25);
        AbstractTaskList aa3 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        aa3.add(t1);
        aa3.add(t2);
        aa3.add(t2);
        Assert.assertEquals(aa2,aa3);
        aa2 = aa.incoming(16,18);
        aa3.remove(t1);
        Assert.assertEquals(aa2,aa3);
    }

}
