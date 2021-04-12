package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * here are tested the methods of the Task class
 */
public class TaskTest {

    @Test
    public void titleFunctions() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);

        //non repetitive
        Task task1 = new Task("task 1", time1);
        Assert.assertEquals(task1.getTitle(), "task 1");
        task1.setTitle("prueva ");
        Assert.assertEquals(task1.getTitle(),"prueva ");

        //repetitive
        Task repetitiveTask = new Task("repetitive", start_time2, end_time2,interval2);
        Assert.assertEquals(repetitiveTask.getTitle(), "repetitive");
        repetitiveTask.setTitle("repetitive title test ");
        Assert.assertEquals(repetitiveTask.getTitle(),"repetitive title test ");


    }

    @Test
    public void activeTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);

        //non repetitive
        Task nonRepetitiveTask = new Task("non repetitive", time1);
        Assert.assertFalse(nonRepetitiveTask.isActive());
        nonRepetitiveTask.setActive(true);
        Assert.assertTrue(nonRepetitiveTask.isActive());
        nonRepetitiveTask.setActive(false);
        Assert.assertFalse(nonRepetitiveTask.isActive());

        //repetitive
        Task repetitiveTask = new Task("repetitive", start_time2, end_time2, interval2);
        Assert.assertFalse(repetitiveTask.isActive());
        repetitiveTask.setActive(true);
        Assert.assertTrue(repetitiveTask.isActive());
        repetitiveTask.setActive(false);
        Assert.assertFalse(repetitiveTask.isActive());
    }

    @Test
    public void getTimeFunctions() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time4 = LocalDateTime.of(2022,9,1,18,0,0);

        //Non repetitive
        Task task1 = new Task("task 1 ", time1);
        Assert.assertEquals(task1.getTime(), time1);
        task1.setTime(time4);
        Assert.assertEquals(task1.getTime(), time4);
        Assert.assertEquals(task1.getStartTime(), time4);
        Assert.assertEquals(task1.getEndTime(), time4);

        //repetitive
        Task repetitiveTask = new Task("repetitive task ", start_time2, end_time2, interval2);
        Assert.assertEquals(repetitiveTask.getTime(), start_time2);
        repetitiveTask.setTime(start_time3,end_time3, interval3);
        Assert.assertEquals(repetitiveTask.getTime(), start_time3);
        Assert.assertEquals(repetitiveTask.getStartTime(), start_time3);
        Assert.assertEquals(repetitiveTask.getEndTime(), end_time3);
    }

    @Test
    public void intervalsTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time3 = LocalDateTime.of(2022,9,1,18,0,0);

        //non repetitive
        Task nonRepetitive = new Task("non repetitive ", time1);
        Assert.assertEquals(nonRepetitive.getRepeatInterval(), null);

        //repetitive
        Task repetitive = new Task("non repetitive ", start_time2, end_time2, interval2);
        Assert.assertEquals(repetitive.getRepeatInterval(), interval2);
    }

    @Test
    public void setTimeFunctions() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time4 = LocalDateTime.of(2022,9,1,18,0,0);

        //Non repetitive
        Task task1 = new Task("task 1 ", time1);
        Assert.assertEquals(task1.getTime(), time1);
        task1.setTime(time4);
        Assert.assertEquals(task1.getTime(), time4);
        Assert.assertEquals(task1.getStartTime(), time4);
        Assert.assertEquals(task1.getEndTime(), time4);
        task1.setTime(start_time2,end_time2,interval2);
        Assert.assertEquals(task1.getTime(), start_time2);
        Assert.assertEquals(task1.getStartTime(), start_time2);
        Assert.assertEquals(task1.getEndTime(), end_time2);

        //repetitive
        Task repetitiveTask = new Task("repetitive task ", start_time2, end_time2, interval2);
        Assert.assertEquals(repetitiveTask.getTime(), start_time2);
        repetitiveTask.setTime(start_time3,end_time3, interval3);
        Assert.assertEquals(repetitiveTask.getTime(), start_time3);
        Assert.assertEquals(repetitiveTask.getStartTime(), start_time3);
        Assert.assertEquals(repetitiveTask.getEndTime(), end_time3);
        repetitiveTask.setTime(time1);
        Assert.assertEquals(repetitiveTask.getTime(), time1);
        Assert.assertEquals(repetitiveTask.getStartTime(), time1);
        Assert.assertEquals(repetitiveTask.getEndTime(), time1);
    }

    @Test
    public void repetitiveTest() throws  Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time3 = LocalDateTime.of(2022,9,1,18,0,0);

        //non repetitive
        Task nonRepetitive = new Task(" non repetitive", time1);
        Assert.assertFalse(nonRepetitive.isRepeated());
        nonRepetitive.setTime(start_time2, end_time2,interval2);
        Assert.assertTrue(nonRepetitive.isRepeated());

        //repetitive
        Task repetitive = new Task("repetitive", start_time2, end_time2, interval2);
        Assert.assertTrue(repetitive.isRepeated());
        repetitive.setTime(time1);
        Assert.assertFalse(repetitive.isRepeated());
    }

    @Test
    public void nextTimeAfterTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime time3 = LocalDateTime.of(2022,3,1,9,15,0);
        LocalDateTime int3 = LocalDateTime.of(2022,3,1,14,15);
        LocalDateTime time4 = LocalDateTime.of(2022,9,1,18,0,0);

        Task task = new Task("Model ", start_time2,end_time2,interval2);
        Assert.assertEquals(task.nextTimeAfter(start_time3), null);
        task.setActive(true);
        Assert.assertEquals(task.nextTimeAfter(time3), int3);
        Assert.assertEquals(task.nextTimeAfter(time4), null);
        task.setTime(time1);
        Assert.assertEquals(task.nextTimeAfter(start_time3), time1);
        Assert.assertEquals(task.nextTimeAfter(end_time2), null);
        task.setActive(false);
        Assert.assertEquals(task.nextTimeAfter(start_time3), null);
    }

    @Test
    public void exceptionsTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(-2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(-2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time3 = LocalDateTime.of(2022,9,1,18,0,0);
        try{
            Task task = new Task("task", time1);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Year should not be negative or zero");
        }
        try {
            Task task = new Task("task1", start_time2, end_time2,interval2);
        }catch (IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Year should not be negative or zero");
        }


    }
}
