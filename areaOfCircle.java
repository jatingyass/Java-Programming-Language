import java.util.Scanner;

public class areaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter radius of circle r = ");
        float r = sc.nextFloat();
        float area = 3.14f*r*r;
        System.out.println("area = "+ area);
        
    }
}
