import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //Wczytaj z klawiatury 5 dowolnych liczb, wyswietl je a nastepnie odwroc kolejnosc w tablicy i wyswietl
        Scanner scan = new Scanner(System.in);
        Double[] tablica = new Double[5];
        for(int i=0;i<5;i++){
            System.out.print("\nPodaj liczbe: ");
            tablica[i] = scan.nextDouble();
        }
        for(int i=0;i<5;i++){
            System.out.println(tablica[i] + " ");
        }
    }
}