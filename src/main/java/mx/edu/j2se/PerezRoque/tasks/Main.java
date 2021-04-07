package mx.edu.j2se.PerezRoque.tasks;

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
/*--->*/Task task1 = new Task("task 1",7, 12,3);
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

	}
}
