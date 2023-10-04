import java.util.Random;
import java.util.Scanner;


public class main {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[38m";
    public static void main(String[] args) {
        String welcome = "\r\n" + //
                "\t   ____                           _             \r\n" + //
                "\t  / ___| ___ _ __   ___ _ __ __ _| |_ ___  _ __ \r\n" + //
                "\t | |  _ / _ \\ '_ \\ / _ \\ '__/ _` | __/ _ \\| '__|\r\n" + //
                "\t | |_| |  __/ | | |  __/ | | (_| | || (_) | |   \r\n" + //
                "\t  \\____|\\___|_| |_|\\___|_|  \\__,_|\\__\\___/|_|   \r\n" + //
                "                                                \r\n" + //
                "";
        System.out.println(ANSI_YELLOW+welcome+ANSI_RESET+ANSI_BLUE+"\n\t\tGenerator liczb pseldolosowych\r\n"+ANSI_RED+"\tMade by Kacper Chamala\n"+ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print(ANSI_CYAN);
        System.out.print("\nLiczba losowan: ");
        System.out.print(ANSI_GREEN);
        int n = scan.nextInt();
        while(n < 1)
        {
            System.out.print("Podaj n>0: ");
            System.out.print(ANSI_GREEN);
            n = scan.nextInt();
        }
        System.out.print(ANSI_CYAN);
        System.out.print("\nZakres numerow od: ");
        System.out.print(ANSI_GREEN);
        int ZakresOd = scan.nextInt();
        while(ZakresOd < 1)
        {
            System.out.print("Podaj ZakresOd>0: ");
            System.out.print(ANSI_GREEN);
            n = scan.nextInt();
        }
        System.out.print(ANSI_CYAN);
        System.out.print("\nZakres numerow do: ");
        System.out.print(ANSI_GREEN);
        int ZakresDo = scan.nextInt();
        while(ZakresDo < ZakresOd)
        {
            System.out.print("Zakres Do nie moze byc mniejszy niz Zakred Od!\r\nPodaj ZakresDo>ZakresOd: ");
            System.out.print(ANSI_GREEN);
            n = scan.nextInt();
        }
        int[] zliczacz = new int[ZakresDo-ZakresOd+1];
        System.out.println(ANSI_RESET);
        Random rand = new Random();
        for(int i = 1; i <= n; i++)
        {
        int a = rand.nextInt(ZakresDo-ZakresOd+1)+ZakresOd;
        zliczacz[a-1]=zliczacz[a-1]+1;
        System.out.println(ANSI_CYAN+"Liczba "+ANSI_RESET+ANSI_WHITE+i+ANSI_RESET+ANSI_CYAN+" wylosowana: "+ANSI_YELLOW+a+ANSI_RESET);
        }
        for (int i=ZakresOd; i <= ZakresDo; i++) {
            System.out.print("\n"+ANSI_CYAN+"Liczba "+ANSI_RESET+ANSI_WHITE+i+ANSI_RESET+ANSI_CYAN+" wystapila: ");
            for (int j = 0; j < zliczacz[i-ZakresOd]; j++) {
                System.out.print(ANSI_YELLOW+"*"+ANSI_RESET);
            }
        }
        System.out.println("\n");
    }
}

