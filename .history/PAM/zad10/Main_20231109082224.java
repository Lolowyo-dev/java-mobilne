package PAM.zad10;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner skan = new Scanner(System.in);
        Float liczba;
        char zn;
        System.out.print("\nPodaj liczbe: ");
        liczba = skan.nextFloat();

        System.out.print("\nPodaj r jak radiany, s jak stopnie: ");
        zn = skan.next().charAt(0);;

        liczba = zn=='r' ? liczba*180/Math.PI : liczba*Math.PI/180;
        
        System.out.println("\nWynik wynosi: "+liczba+(zn=='r'? " stopni":" rad"));

        skan.close();
    }
}