package mx.edu.j2se.PerezRoque.tasks;

public class Persona {
    String nombre;
    int edad;
    String sexo;
    float altura;
    String nacionalidad;

    /**
     * @return String
     */
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String esLegal(){
        if (this.edad >= 18){
            return "Bienvenido al bar!!";
        }
        else{
            return "Sigue participando";
        }
    }

}
