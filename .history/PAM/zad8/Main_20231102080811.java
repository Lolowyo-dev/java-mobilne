public class Main{
    public static void main(String[] args){
        String tekst = "Lubie programowac";
        System.out.println(tekst);
        char[] tablica = new char[tekst.length()];
        tablica = tekst.toCharArray();

        for(int i=0, j=tablica.length-1; i<tablica.length; i++){

        }

        for(int i = 0; i < tekst.length(); i++){
            System.out.print(tablica[i]);
        }
    }
}