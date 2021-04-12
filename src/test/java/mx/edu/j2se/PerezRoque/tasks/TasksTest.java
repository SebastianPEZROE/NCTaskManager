package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.*;

public class TasksTest {

    @Test
    public void incomingTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time4 = LocalDateTime.of(2022,9,1,18,0,0);

        Task t1 = new Task("Lunch with a beautiful girl", time1);
        Task t2 = new Task("Morning run", start_time2,end_time2,interval2);
        Task t3 = new Task("Taking medication", start_time3,end_time3,interval3);
        Task t4 = new Task("Meeting with friends", time4);
        t1.setActive(true);
        t2.setActive(true);
        t3.setActive(true);
        t4.setActive(true);

        AbstractTaskList h = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        h.add(t1);
        h.add(t2);
        h.add(t3);
        h.add(t4);
        LocalDateTime current_s = LocalDateTime.of(2022,8,24,17,0,0);
        LocalDateTime current_e = LocalDateTime.of(2022,8,26,8,0,0);

        Iterable<Task> p = h;
        Iterable<Task> i = Tasks.incoming(p, current_s, current_e);
        Iterator<Task> q = i.iterator();

        Assert.assertTrue(q.next().equals(t2));
        Assert.assertTrue(q.next().equals(t3));
        Assert.assertFalse(q.hasNext());
    }

    @Test
    public void calendarTest() throws Exception{
        LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
        LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
        LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
        LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
        LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
        LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
        LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
        LocalDateTime time3 = LocalDateTime.of(2022,9,1,18,0,0);

        Task t1 = new Task("Lunch with a beautiful girl", time1);
        Task t2 = new Task("Morning run", start_time2,end_time2,interval2);
        Task t3 = new Task("Taking medication", start_time3,end_time3,interval3);
        Task t4 = new Task("Meeting with friends", time3);
        t1.setActive(true);
        t2.setActive(true);
        t3.setActive(true);
        t4.setActive(true);

        AbstractTaskList h = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        h.add(t1);
        h.add(t2);
        h.add(t3);
        h.add(t4);
        LocalDateTime current_s = LocalDateTime.of(2022,8,25,8,0,0);
        LocalDateTime current_e = LocalDateTime.of(2022,8,26,8,0,0);

        Iterable<Task> u = h;
		SortedMap<LocalDateTime, Set<Task>> d = Tasks.calendar(u,current_s,current_e);
        Iterator i = d.keySet().iterator();

        Iterator g = d.get(i.next()).iterator();
        Assert.assertEquals(g.next(), t2);
        Assert.assertEquals(g.next(), t3);
        Assert.assertFalse(g.hasNext());

        Iterator k = d.get(i.next()).iterator();
        Assert.assertEquals(k.next(), t2);
        Assert.assertFalse(k.hasNext());
    }



}
