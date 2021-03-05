package mx.edu.j2se.PerezRoque.evaluation;

public class Circle {
    private double radius;

    public Circle(){
        this.radius = 1;
    }

    public Circle(double radius)throws IllegalArgumentException{
        if (radius < 0){
            throw new IllegalArgumentException(
                    "Radius should not be negative, try another value please"
            );
        }
        this.radius = radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException{
        if (radius < 0){
            throw new IllegalArgumentException(
                    "Radius should not be negative, try with a positive one"
            );
        }
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return (Math.PI * radius * radius);
    }
}
