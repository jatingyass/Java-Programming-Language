import java.util.Scanner;

public class productof2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first no. a = ");
        int a = sc.nextInt();
        System.out.print("enter second no. b = ");
        int b = sc.nextInt();
        int product = a*b;
        System.out.println("product of two no. a*b = "+ product);
    }
}
