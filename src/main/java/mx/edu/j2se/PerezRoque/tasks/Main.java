package mx.edu.j2se.PerezRoque.tasks;

import javafx.util.converter.LocalTimeStringConverter;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Set;
import java.util.SortedMap;

public class Main {
	public static void main(String[] args) {
		/*Persona estudiante = new Persona();
		estudiante.setNombre("Eduardo");
		estudiante.setEdad(18);
		String simon = estudiante.esLegal();
		System.out.println(estudiante.nombre + ": " + simon);

		Persona estudiante2 = new Persona();
		estudiante2.setNombre("Arturo");
		estudiante2.setEdad(16);
		String simon_estudiante2 = estudiante2.esLegal();
		System.out.println(estudiante2.nombre + ": " + simon_estudiante2);

		Task task1 = new Task("Morning running", 6);
		System.out.println(task1.getTitle());
		task1.setTitle("sleep");
		System.out.println(task1.getTitle());
		System.out.println(task1.isActive());
		System.out.println(task1.getTime());
		task1.setTime(7);
		System.out.println(task1.getTime());
		System.out.println(task1.getStartTime());
		System.out.println(task1.getEndTime());
		System.out.println(task1.getRepeatInterval());
		task1.setTime(4,48,8);
		System.out.println(task1.isActive());
		task1.setActive(true);
		System.out.println(task1.isActive());
		System.out.println(task1.getTime());
		System.out.println(task1.getStartTime());
		System.out.println(task1.getEndTime());
		System.out.println(task1.getRepeatInterval());
		task1.setTime(15);
		System.out.println(task1.getEndTime());
		System.out.println(task1.nextTimeAfter(16));
		task1.setTime(3,120,12);
		System.out.println(task1.nextTimeAfter(3));
		System.out.println(task1.nextTimeAfter(121));

		task1.setActive(true);
		Task task2 = new Task("take a shower", 7);
		task2.setActive(false);
		Task task3 = new Task("brush teeth", 710);
		task3.setActive(false);
		Task task4 = new Task("get wear", 11);
		Task task5 = new Task("break fast", 12, 72, 24);
		task5.setActive(true);
------>	ArrayTaskList list1 = new ArrayTaskList();
		list1.add(task1);
		list1.add(task2);
		list1.add(task3);
		list1.add(task4);
		list1.add(task5);
		list1.add(task2);

		//System.out.println(list1.size());
		//System.out.println(list1.remove(task1));
		//System.out.println(list1.remove(task1));
		//System.out.println(list1.remove(task3));
		//System.out.println(list1.remove(task1));
		//System.out.println(list1.remove(task2));
		System.out.println(list1.size());

		System.out.println(list1.getTask(0));

		//ArrayTaskList list2; //new ArrayTaskList();
		//list2 =
		//System.out.println(list1.incoming(5,8).size());
		//System.out.println(list1.incoming(5,8).getTask(0));
		//System.out.println(list2.size());
		//System.out.println(list2.getTask(3));

		//Task task1000 = new Task("get out", -2000);
		//System.out.println(task1000.getEndTime());

------>	LinkedTaskList list = new LinkedTaskList();
		//list.add(task1);
		//list.add(task2);
		//list.add(task3);
		//list.add(task4);
		//list.add(task5);
		//list.cual_es();
		System.out.println(list.size());

		System.out.println(list.remove(task5));
		list.remove(task2);

		System.out.println(list.size());
		//System.out.println(list.getTask(1));
		list.add(task5);
		System.out.println(list.incoming(4,15).size());
		//String val = "ARRAY";
----->	AbstractTaskList A_list = TaskListFactory.createTaskList( ListTypes.types.ARRAY);
		A_list.add(task1);
		A_list.add(task2);
		A_list.add(task1);
		A_list.add(task3);
		A_list.add(task4);
		A_list.remove(task1);
		A_list.add(task5);
		System.out.println(A_list.size());
		System.out.println(A_list.incoming(0,100));

		AbstractTaskList L_list = TaskListFactory.createTaskList(ListTypes.types.LINKED);
		L_list.add(task1);
		L_list.add(task2);
		L_list.add(task3);
		L_list.add(task4);
		L_list.add(task5);
		L_list.add(task2);

		System.out.println(L_list.size());
		L_list.remove(task2);
		System.out.println(L_list.getTask(4));
		System.out.println(L_list.incoming(0,100));
		System.out.println(A_list.incoming(0,100));*/
//equals
/*--->*//*Task task1 = new Task("task 1",7, 12,3);
		Task task2 = new Task("task 222",7);
		task2.setTime(7,12,3);
		//System.out.println(task1.equals(task2));
		//System.out.println(task1.hashCode());
		//System.out.println(task2.hashCode());
		//System.out.println(task1.toString());
		task2.setTime(4);

		AbstractTaskList L_list = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
		L_list.add(task1);
		L_list.add(task2);
		AbstractTaskList L_list1 = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
		L_list1.add(task1);
		L_list1.add(task1);
		//System.out.println(L_list.equals(L_list1));
		//System.out.println(L_list.toString());

		ArrayTaskList g = (ArrayTaskList) L_list.cloning();
		//System.out.println(g.toString());

		AbstractTaskList L = TaskListFactory.createTaskList(ListTypes.types.LINKED);
		L.add(task1);
		L.add(task2);
		AbstractTaskList L2 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
		L2.add(task1);
		L2.add(task2);
		L2.add(task1);
		L2.add(task1);
		L2.add(task2);
		L2.add(task1);
		L2.remove(task2);
		L2.remove(task1);
		//System.out.println(L.equals(L2));

		LinkedTaskList w = (LinkedTaskList) L.cloning();
		//System.out.println(L.toString());
		//System.out.println(w.toString());

		Task r = (Task) task1.clone();
		//System.out.println(r.toString());

		//System.out.println(L2.size());

		task2.setActive(true);
		task1.setActive(true);
		Task task3 = new Task("el task", 80);
		L_list.add(task3);
		L_list.add(task2);
		task3.setActive(true);
		//System.out.println(L_list.size());
		//L_list.getStream().filter(element -> element.isActive()).forEach(System.out::println);
		//L.getStream().filter(Task::isActive).forEach(System.out::println);
		L.incoming(4,7).getStream().forEach(System.out::println);
		L_list.incoming(5,8);
		L_list1.incoming(0,0);
		L2.incoming(0,0);

		LocalDate time = LocalDate.of(2070, 12,29);
		LocalDateTime t = LocalDateTime.of(2020,2,8,3,30);
		System.out.println(time);
		System.out.println(t);
		System.out.println(LocalDateTime.now());
		System.out.println(t.isBefore(LocalDateTime.now()));

		Iterable<Task> c= L;//TaskListFactory.createTaskList(ListTypes.types.LINKED);
		//c.forEach(System.out::println);

		Iterable<Task> i = Tasks.incoming(c,t,t);
		*/

		/*LocalDateTime time1 = LocalDateTime.of(2022,8,24,16,0,0);
		LocalDateTime start_time2 = LocalDateTime.of(2022,3,1,8,15);
		LocalDateTime end_time2 = LocalDateTime.of(2022,9,1,8,15,0);
		LocalDateTime interval2 = LocalDateTime.of(0,1,1,6,0,0,0);
		LocalDateTime start_time3 = LocalDateTime.of(2022,8,20,8,15,0);
		LocalDateTime end_time3 = LocalDateTime.of(2022,8,28,8,15,0);
		LocalDateTime interval3 = LocalDateTime.of(0,1,1,12,0);
		LocalDateTime time3 = LocalDateTime.of(2022,9,1,18,0,0);
		//falta que el intervalo sea menor aun mes y un dia
		//que el comienzo mas el intervalo no sea mayor al fin
		//checar  restricciones de next time after
		//checar las ecepciones de task
		//poner exepciones en todo lo demas
		//lo que siga saliendo, hay que checar todo
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
		LocalDateTime current_e = LocalDateTime.of(2022,8,25,15,0,0);

		Iterable<Task> u = h;
		//Iterable<Task> i = Tasks.incoming(u, current, end_time );
		//System.out.println(i);

		SortedMap<LocalDateTime, Set<Task>> d = Tasks.calendar(u,current_s,current_e);
		d.keySet().forEach(element->System.out.println("date: " + element +
				", number of tasks: " + d.get(element).size() +
				", Tasks: " + d.get(element) ));
		//System.out.println(d);
		DateTimeFormatter g = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:ns");
		String v = start_time3.format(g);
		//System.out.println(v);

		long r = ChronoUnit.MINUTES.between(start_time3, end_time3);

		//System.out.println(r);
		LocalDateTime p =start_time3.plusMinutes(r);
		//System.out.println(p);*/


	}
}
