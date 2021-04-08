package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Here are tested all the ArrayTaskList functions
 */
public class ArrayTaskListTest {

    @Test
    public void addAndgetTaskTest() throws Exception{
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        ArrayTaskList a1= new ArrayTaskList();
        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(t2);
        Assert.assertEquals(a1.getTask(0), t1);
        Assert.assertEquals(a1.getTask(2), t3);
        Assert.assertEquals(a1.getTask(3), t2);
        try{
            a1.add(null);
        }catch (NullPointerException e){
            Assert.assertEquals(e.getMessage(),"Task object should not be null");
        }
        try{
            a1.getTask(-1);
        }catch (IndexOutOfBoundsException e){
            Assert.assertEquals(e.getMessage(),"Index should not be negative neither greater than the number of tasks that contains, please");
        }
    }

    @Test
    public void removeAndSizeTest(){
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        ArrayTaskList a1= new ArrayTaskList();
        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(t2);
        Assert.assertEquals(a1.size(), 4);
        Assert.assertTrue(a1.remove(t1));
        Assert.assertEquals(a1.size(), 3);
        Assert.assertFalse(a1.remove(t1));
        Assert.assertEquals(a1.size(), 3);
        Assert.assertTrue(a1.remove(t2));
        Assert.assertEquals(a1.size(), 2);
    }

    @Test
    public void iteratorTest(){
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        ArrayTaskList a1= new ArrayTaskList();
        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(t2);
        Iterator<Task> i = a1.iterator();
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t1);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t3);
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(), t2);
        Assert.assertFalse(i.hasNext());
        Assert.assertNull(i.next());
    }

    @Test
    public void equalsAndCloningTest(){
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        ArrayTaskList a1= new ArrayTaskList();
        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(t2);
        ArrayTaskList a2 = a1.cloning();
        Assert.assertEquals(a2,a1);
        Assert.assertTrue(a2.equals(a1));
        a2.remove(t2);
        Assert.assertFalse(a2.equals(a1));
        ArrayTaskList a3 = a2.cloning();
        Assert.assertEquals(a3,a2);
    }

}
