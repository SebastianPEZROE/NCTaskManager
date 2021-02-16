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
	}

}
