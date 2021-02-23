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
		task1.setTime(3,120,12);
		System.out.println(task1.nextTimeAfter(15));
		System.out.println(task1.nextTimeAfter(121));

	}
}
