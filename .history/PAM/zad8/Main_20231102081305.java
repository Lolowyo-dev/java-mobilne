public class Main{
    public static void main(String[] args){
        String tekst = "Lubie programowac";
        System.out.println(tekst);
        char[] tablica = new char[tekst.length()];
        tablica = tekst.toCharArray();

        for(int i=0, j=tablica.length-1; i<j; i++, j--){
            char temp = tablica[i];
            tablica[i] = tablica[j];
            tablica[j] = temp;
        }

        for(int i = 0; i < tekst.length(); i++){
            System.out.print(tablica[i]);
        }
    }
}