package mx.edu.j2se.PerezRoque.tasks;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;

public class TaskIOTest {

    @Test
    public void writeAndReadTest() throws Exception{
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

        FileOutputStream file = new FileOutputStream("C:\\Users\\SPR\\Documents\\netcracker\\prueva.txt");
        OutputStream out = new ObjectOutputStream(file);
        TaskIO.write(h,out);

        AbstractTaskList t = TaskListFactory.createTaskList(ListTypes.types.LINKED);
		FileInputStream filein = new FileInputStream("C:\\Users\\SPR\\Documents\\netcracker\\prueva.txt");
		InputStream in = new ObjectInputStream(filein);
		TaskIO.read(t,in);

		Assert.assertEquals(h.size(), t.size());
		for (int i =0 ; i<h.size(); i++){
		    Assert.assertTrue(h.getTask(i).equals(t.getTask(i)));
        }
		Assert.assertEquals(h,t);
    }

    @Test
    public void writeBinaryAndReadBinaryTest() throws Exception {
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
        AbstractTaskList h = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        h.add(t1);
        h.add(t2);
        h.add(t3);
        h.add(t4);
        AbstractTaskList t = TaskListFactory.createTaskList(ListTypes.types.ARRAY);

        File f =  new File("C:\\Users\\SPR\\Documents\\netcracker\\otra_prueva.txt");
        TaskIO.writeBinary(h, f);
        TaskIO.readBinary(t, f);

        Assert.assertEquals(h.size(), t.size());
        for (int i =0 ; i<h.size(); i++){
            Assert.assertTrue(h.getTask(i).equals(t.getTask(i)));
        }
        Assert.assertEquals(h,t);
    }

    @Test
    public void writeAndReadJsonFormatTest () throws Exception{
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
        AbstractTaskList h = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        h.add(t1);
        h.add(t2);
        h.add(t3);
        h.add(t4);
        AbstractTaskList t = TaskListFactory.createTaskList(ListTypes.types.ARRAY);

        Writer wr = new FileWriter("C:\\Users\\SPR\\Documents\\netcracker\\Json_prueva.txt");
        TaskIO.write(h,wr);
        Reader rd = new FileReader("C:\\Users\\SPR\\Documents\\netcracker\\Json_prueva.txt");
        TaskIO.read(t, rd);

        Assert.assertEquals(h.size(), t.size());
        for (int i =0 ; i<h.size(); i++){
            Assert.assertTrue(h.getTask(i).equals(t.getTask(i)));
        }
        Assert.assertEquals(h,t);
    }

    @Test
    public void writeTextAndReadTextTest() throws Exception{
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
        AbstractTaskList h = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        h.add(t1);
        h.add(t2);
        h.add(t3);
        h.add(t4);
        AbstractTaskList t = TaskListFactory.createTaskList(ListTypes.types.ARRAY);

        File f =  new File("C:\\Users\\SPR\\Documents\\netcracker\\Json_otra_prueva.txt");
        TaskIO.writeText(h, f);
        TaskIO.readText(t, f);

        Assert.assertEquals(h.size(), t.size());
        for (int i =0 ; i<h.size(); i++){
            Assert.assertTrue(h.getTask(i).equals(t.getTask(i)));
        }
        Assert.assertEquals(h,t);
    }


}
