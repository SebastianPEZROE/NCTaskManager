package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * Here are tested all the LinkedTaskList functions.
 * Is missing to test stream and to string functions
 */
public class LinkedTaskListTest {

    /*@Test
    public void addAndgetTaskTest() throws Exception{
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        LinkedTaskList a1= new LinkedTaskList();
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
            Assert.assertEquals(e.getMessage(),"Task should not be a null value, try another not null please");
        }
        try{
            a1.getTask(-1);
        }catch (IndexOutOfBoundsException e){
            Assert.assertEquals(e.getMessage(),"index should not be negative neither bigger than the number of tasks it contains");
        }
    }

    @Test
    public void removeAndSizeTest(){
        Task t1 = new Task("t1", 10);
        Task t2 = new Task("t2", 18);
        Task t3 = new Task("t3", 1);
        LinkedTaskList a1= new LinkedTaskList();
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
        LinkedTaskList a1= new LinkedTaskList();
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
        LinkedTaskList a1= new LinkedTaskList();
        a1.add(t1);
        a1.add(t2);
        a1.add(t3);
        a1.add(t2);
        LinkedTaskList a2 = a1.cloning();
        Assert.assertEquals(a2,a1);
        Assert.assertTrue(a2.equals(a1));
        a2.remove(t2);
        Assert.assertFalse(a2.equals(a1));
        LinkedTaskList a3 = a2.cloning();
        Assert.assertEquals(a3,a2);
    }
*/
}
