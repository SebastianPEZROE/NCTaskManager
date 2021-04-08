package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * here is tested the TaskListFactory class
 */
public class TaskListFactoryTest {

    @Test
    public void buildingArrayTasListTest() throws Exception{
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        AbstractTaskList aa = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        aa.add(t1);
        aa.add(t2);
        aa.add(t3);
        aa.add(t2);
        Assert.assertEquals(aa.getTask(0), t1);
        Assert.assertEquals(aa.getTask(2), t3);
        Assert.assertEquals(aa.getTask(3), t2);
        Assert.assertEquals(aa.size(), 4);
        Assert.assertTrue(aa.remove(t1));
        Assert.assertEquals(aa.size(), 3);
        Iterator<Task> i = aa.iterator();
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t3);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertFalse(i.hasNext());
        Assert.assertNull(i.next());
        AbstractTaskList aa2 = aa.cloning();
        Assert.assertEquals(aa2,aa);
        Assert.assertTrue(aa2.equals(aa));
    }

    @Test
    public void buildingLinkedTaskListTest(){
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        AbstractTaskList al = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        al.add(t1);
        al.add(t2);
        al.add(t3);
        al.add(t2);
        Assert.assertEquals(al.getTask(0), t1);
        Assert.assertEquals(al.getTask(2), t3);
        Assert.assertEquals(al.getTask(3), t2);
        Assert.assertEquals(al.size(), 4);
        Assert.assertTrue(al.remove(t1));
        Assert.assertEquals(al.size(), 3);
        Iterator<Task> i = al.iterator();
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t3);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertFalse(i.hasNext());
        Assert.assertNull(i.next());
        AbstractTaskList aa2 = al.cloning();
        Assert.assertEquals(aa2,al);
        Assert.assertTrue(aa2.equals(al));
    }

}
