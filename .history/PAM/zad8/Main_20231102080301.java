public class Main{
    public static void main(String[] args){
        String tekst = "Lubie programowac";
        char[] tablica = new char[tekst.length()];
        int j = te;
        for(int i = 0; i < tekst.length(); i++){
            tablica[j++] = tekst.charAt(i);
        }
        for(int i = tekst.length() - 1; i >= 0;i--){
            System.out.print(tablica[i]);
        }
    }
}