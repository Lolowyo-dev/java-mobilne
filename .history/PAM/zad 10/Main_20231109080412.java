package PAM.zad9;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner aha = new Scanner(System.in);
        Double liczba;
        String zn;
        System.out.print("\nPodaj liczbe: ");
        liczba = aha.nextDouble();

        System.out.print("\nPodaj r jak radiany, s jak stopnie: ");
        zn = aha.nextLine();

        liczba = liczba=='r' ? 1.3 : 2.3;
        
        aha.close();
    }
}