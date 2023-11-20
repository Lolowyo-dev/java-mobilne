package PAM.zad10;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner aha = new Scanner(System.in);
        Double liczba;
        char zn;
        System.out.print("\nPodaj liczbe: ");
        liczba = aha.nextDouble();

        System.out.print("\nPodaj r jak radiany, s jak stopnie: ");
        zn = aha.next().charAt(0);;

        liczba = zn=="r" ? liczba*180/Math.PI : liczba*Math.PI/180;
        
        System.out.println("\nWynik wynosi: "+liczba);

        aha.close();
    }
}