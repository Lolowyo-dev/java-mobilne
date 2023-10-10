package PAM.zad5;
import java.io.*;

class pole_prostokata{
    double a,b,pole;

    public void czytaj_dane()
    throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Program oblicza pole prostokata");
        System.out.print("Podaj bok a: ");
        a = Double.parseDouble(br.readLine());
        System.out.print("Podaj bok b: ");
        b = Double.parseDouble(br.readLine());
    }

    public void przetworz_dane(){
        pole = a*b;
    }

    public void wyswietl_wynik(){
        System.out.println("Pole prostokata o boku a = ");
        System.out.printf("%2.2f", a);
        System.out.println("i boku b = ");
        System.out.printf("%2.2f", b);
        System.out.println(" wynosi ");
        System.out.printf("%2.2f.\n", pole);
    }
}

public class Main{
    public static void main(String[] args)
    throws Exception
    {
        pole_prostokata pole = new pole_prostokata();

        pole.czytaj_dane();
        pole.przetworz_dane();
        pole.wyswietl_wynik();
    }
}