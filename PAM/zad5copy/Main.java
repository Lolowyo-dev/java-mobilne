package PAM.zad5copy;
import java.io.*;
import java.util.Scanner;

class pole_prostokata{
    double a,b,pole;

    public void czytaj_dane()
    throws IOException // daje mozliwosc input/output w klasie
    {
        // deklaracja metody zczytywania danych
        Scanner br = new Scanner(System.in);
        System.out.println("Program oblicza pole prostokata");
        System.out.print("Podaj bok a: ");
        a = br.nextDouble();
        System.out.print("Podaj bok b: ");
        b = br.nextDouble();
    }

    public void przetworz_dane(){
        pole = a*b;
    }

    public void wyswietl_wynik(){
        System.out.print("Pole prostokata o boku a = ");
        //  %[flags][width][.precision]conversion-character
        /*  
            s formats strings.
            d formats decimal integers.
            f formats floating-point numbers.
            t formats date/time values. 
        */
        System.out.printf("%2.2f", a);
        System.out.print(" i boku b = ");
        System.out.printf("%2.2f", b);
        System.out.print(" wynosi ");
        System.out.printf("%2.2f.\n", pole);
    }
}

public class Main{
    public static void main(String[] args)
    throws IOException
    {
        pole_prostokata pole = new pole_prostokata();

        pole.czytaj_dane();
        pole.przetworz_dane();
        pole.wyswietl_wynik();
    }
}

// modification - skożystać ze skanera