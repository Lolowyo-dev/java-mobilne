public class Main{
    public static void main(String[] args){
        String tekst = "Lubie programowac";
        char[] tablica = new char[tekst.length()];
        int j = tekst.length()-1;
        for(int i = 0; i < tekst.length(); i++){
            tablica[j--] = tekst.charAt(i);
        }
        for(int i = 0; i < tekst.length(); i++){
            System.out.print(tablica[i]);
        }
    }
}