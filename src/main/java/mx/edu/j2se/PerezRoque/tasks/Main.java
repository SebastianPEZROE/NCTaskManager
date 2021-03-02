package mx.edu.j2se.PerezRoque.tasks;

public class Main {
	public static void main(String[] args) {
		Persona estudiante = new Persona();
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
		task5.setActive(false);
		ArrayTaskList list1 = new ArrayTaskList();
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
		System.out.println(list1.incoming(5,8).size());
		System.out.println(list1.incoming(5,8).getTask(0));
		//System.out.println(list2.size());
		//System.out.println(list2.getTask(3));



	}
}
