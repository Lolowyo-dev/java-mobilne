public class Main{
    public static void main(String[] args){
        String tekst = "Lubie programowac";
        char[] tablica = new char[tekst.length()];
        tablica = tekst.toCharArray(tekst);
        for(int i = 0; i < tekst.length(); i++){
            System.out.print(tablica[i]);
        }
    }
}