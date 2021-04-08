package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterTest;

/**
 * here are tested the methods of the Task class
 */
public class TaskTest {

    @Test
    public void titleFunctions() throws Exception{
        //non repetitive
        Task task1 = new Task("task 1", 1);
        Assert.assertEquals(task1.getTitle(), "task 1");
        task1.setTitle("prueva ");
        Assert.assertEquals(task1.getTitle(),"prueva ");

        //repetitive
        Task repetitiveTask = new Task("repetitive", 18, 35,2);
        Assert.assertEquals(repetitiveTask.getTitle(), "repetitive");
        repetitiveTask.setTitle("repetitive title test ");
        Assert.assertEquals(repetitiveTask.getTitle(),"repetitive title test ");


    }

    @Test
    public void activeTest() throws Exception{
        //non repetitive
        Task nonRepetitiveTask = new Task("non repetitive", 56);
        Assert.assertFalse(nonRepetitiveTask.isActive());
        nonRepetitiveTask.setActive(true);
        Assert.assertTrue(nonRepetitiveTask.isActive());
        nonRepetitiveTask.setActive(false);
        Assert.assertFalse(nonRepetitiveTask.isActive());

        //repetitive
        Task repetitiveTask = new Task("repetitive", 56);
        Assert.assertFalse(repetitiveTask.isActive());
        repetitiveTask.setActive(true);
        Assert.assertTrue(repetitiveTask.isActive());
        repetitiveTask.setActive(false);
        Assert.assertFalse(repetitiveTask.isActive());
    }

    @Test
    public void getTimeFunctions() throws Exception{
        //Non repetitive
        Task task1 = new Task("task 1 ", 3);
        Assert.assertEquals(task1.getTime(), 3);
        task1.setTime(15);
        Assert.assertEquals(task1.getTime(), 15);
        Assert.assertEquals(task1.getStartTime(), 15);
        Assert.assertEquals(task1.getEndTime(), 15);

        //repetitive
        Task repetitiveTask = new Task("repetitive task ", 3, 100, 10);
        Assert.assertEquals(repetitiveTask.getTime(), 3);
        repetitiveTask.setTime(1,200, 18);
        Assert.assertEquals(repetitiveTask.getTime(), 1);
        Assert.assertEquals(repetitiveTask.getStartTime(), 1);
        Assert.assertEquals(repetitiveTask.getEndTime(), 200);
    }

    @Test
    public void intervalsTest() throws Exception{
        //non repetitive
        Task nonRepetitive = new Task("non repetitive ", 78);
        Assert.assertEquals(nonRepetitive.getRepeatInterval(), 0);

        //repetitive
        Task repetitive = new Task("non repetitive ", 78, 900, 17);
        Assert.assertEquals(repetitive.getRepeatInterval(), 17);
    }

    @Test
    public void setTimeFunctions() throws Exception{
        //Non repetitive
        Task task1 = new Task("task 1 ", 3);
        Assert.assertEquals(task1.getTime(), 3);
        task1.setTime(15);
        Assert.assertEquals(task1.getTime(), 15);
        Assert.assertEquals(task1.getStartTime(), 15);
        Assert.assertEquals(task1.getEndTime(), 15);
        task1.setTime(2,56,9);
        Assert.assertEquals(task1.getTime(), 2);
        Assert.assertEquals(task1.getStartTime(), 2);
        Assert.assertEquals(task1.getEndTime(), 56);

        //repetitive
        Task repetitiveTask = new Task("repetitive task ", 3, 100, 10);
        Assert.assertEquals(repetitiveTask.getTime(), 3);
        repetitiveTask.setTime(1,200, 18);
        Assert.assertEquals(repetitiveTask.getTime(), 1);
        Assert.assertEquals(repetitiveTask.getStartTime(), 1);
        Assert.assertEquals(repetitiveTask.getEndTime(), 200);
        repetitiveTask.setTime(8);
        Assert.assertEquals(repetitiveTask.getTime(), 8);
        Assert.assertEquals(repetitiveTask.getStartTime(), 8);
        Assert.assertEquals(repetitiveTask.getEndTime(), 8);
    }

    @Test
    public void repetitiveTest() throws  Exception{
        //non repetitive
        Task nonRepetitive = new Task(" non repetitive", 45);
        Assert.assertFalse(nonRepetitive.isRepeated());
        nonRepetitive.setTime(14, 80,4);
        Assert.assertTrue(nonRepetitive.isRepeated());

        //repetitive
        Task repetitive = new Task("repetitive", 45, 8007, 6);
        Assert.assertTrue(repetitive.isRepeated());
        repetitive.setTime(6);
        Assert.assertFalse(repetitive.isRepeated());
    }

    @Test
    public void nextTimeAfterTest() throws Exception{
        Task task = new Task("Model ", 10,50,5);
        Assert.assertEquals(task.nextTimeAfter(28), -1);
        task.setActive(true);
        Assert.assertEquals(task.nextTimeAfter(34), 35);
        Assert.assertEquals(task.nextTimeAfter(80), -1);
        task.setTime(67);
        Assert.assertEquals(task.nextTimeAfter(3), 67);
        Assert.assertEquals(task.nextTimeAfter(100), -1);
        task.setActive(false);
        Assert.assertEquals(task.nextTimeAfter(4), -1);
    }

    @Test
    public void exceptionsTest() throws Exception{
        try{
            Task task = new Task("task", 7);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Time should not be negative");
        }
        try {
            Task task = new Task("task1", 4, 30,-1);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Interval should not be zero neither negative");
        }
        Task task =  new Task(" task 2", 80);
        try{
            task.setTime(-6543);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "time should not be negative");
        }

    }

}
