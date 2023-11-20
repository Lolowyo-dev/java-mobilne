package PAM.zad10;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //cecha, mantysa standard ieee754
        //umozliwia konwersje liczb dla wybranych przez siebie systemow liczbowych
        Scanner skan = new Scanner(System.in);
        Double liczba;
        char zn;
        System.out.print("\nPodaj liczbe: ");
        liczba = skan.nextDouble();

        System.out.print("\nPodaj r jak radiany, s jak stopnie: ");
        zn = skan.next().charAt(0);;

        liczba = zn=='r' ? liczba*180/Math.PI : liczba*Math.PI/180;
        
        System.out.println("\nWynik wynosi: "+liczba+(zn=='r'? " stopni":" rad"));

        skan.close();
    }
}