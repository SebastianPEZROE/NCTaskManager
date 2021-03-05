package mx.edu.j2se.PerezRoque.evaluation;

public class Evaluation1 {
    public void main(){
        try{
            Circle invalidCircle = new Circle(-10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(20);
        Circle circle3 = new Circle(30);

        Circle []Circles_array = new Circle[]{circle1, circle2, circle3};

        int id = biggestCircle(Circles_array);
        double biggest_radius = Circles_array[id].getRadius();
        System.out.println(biggest_radius);

    }

    private int biggestCircle(Circle[] array){
        double biggest = array[0].getRadius();
        int index = 0;
        for (int i = 1; i< array.length; i++){
            if (array[i].getRadius() > biggest ){
                index = i;
            }
        }
        return index;
    }
}
