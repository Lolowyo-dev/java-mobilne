package PAM.zad9;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner aha = new Scanner(System.in);
        Double liczba;
        System.out.print("\nPodaj liczbe: ");
        liczba = aha.nextDouble();

        System.out.print("\nPodaj r jak radiany, s jak stopnie: ");
        char zn;
        zn = char(aha.nextLine());
        
        aha.close();
    }
}