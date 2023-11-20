import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Main1 extends JFrame {
    private JLabel Tytul;
    private JTextField A;
    private JTextField B;
    private JLabel Wynik;

    public Main1() {
        // Tytuł okna
        setTitle("Dzielenie");

        // Ustawienie układu na GridBagLayout dla lepszego rozmieszczenia komponentów
        setLayout(new GridBagLayout());

        // Ustawienie koloru tła głównego okna
        getContentPane().setBackground(new Color(53, 55, 64, 255));

        // Konfiguracja ograniczeń układu GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Odstęp między komponentami

        // Inicjalizacja pól tekstowych
        A = new JTextField(20);
        B = new JTextField(20);

        // Stylizacja i konfiguracja pola tekstowego "Imię"
        A.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Biały obramowanie
        A.setForeground(Color.WHITE); // Kolor tekstu biały
        A.addFocusListener(new zmiana_stanu(A)); // Dodanie obsługi zmiany stanu (dla efektu zmiany koloru)
        A.setFont(new Font("Arial", Font.PLAIN, 20)); // Ustawienie czcionki

        // Stylizacja i konfiguracja pola tekstowego "B"
        B.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        B.setBackground(Color.DARK_GRAY);
        B.setForeground(Color.WHITE);
        B.addFocusListener(new zmiana_stanu(B));
        B.setFont(new Font("Arial", Font.PLAIN, 20));


        // Inicjalizacja przycisku "Wyślij"
        JButton przycisk = new JButton("Oblicz");
        przycisk.setFont(new Font("Arial", Font.BOLD, 18)); // Zmień czcionkę przycisku na pogrubioną
        przycisk.setBackground(new Color(55, 55, 55, 255)); // Zmień kolor tła przycisku
        przycisk.setForeground(Color.BLACK); // Zmień kolor tekstu przycisku
        przycisk.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Dodaj czarny obramowanie przycisku

        Wynik = new JLabel();
        Wynik.setForeground(Color.WHITE); // Kolor tekstu biały
        Wynik.setFont(new Font("Arial", Font.PLAIN, 18));

        Tytul = new JLabel();
        Tytul.setForeground(Color.WHITE); // Kolor tekstu biały
        Tytul.setFont(new Font("Arial", Font.PLAIN, 24));

        // Inicjalizacja validacji po kliknięciu w przycisk
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Oblicz();
            }
        });


        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Map<TextAttribute, Object> fontAttributes = new HashMap<>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labelFont = labelFont.deriveFont(fontAttributes);
        Wynik.setFont(labelFont);

        //Label do pola tekstowego A
        constraints.gridx = 0;
        constraints.gridy = 0;

        Tytul.setText("Kalkulator Dzielenia");
        add(Tytul, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;

        JLabel ALabel = new JLabel("A: ");
        ALabel.setForeground(Color.WHITE);
        ALabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(ALabel, constraints);

        //pole tekstowe A
        constraints.gridx = 3;
        constraints.gridwidth = 5;
        add(A, constraints);

        //Label do pola tekstowego B
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        JLabel BLabel = new JLabel("B: ");
        BLabel.setForeground(Color.WHITE);
        BLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(BLabel, constraints);

        //pole tekstowe B
        constraints.gridx = 3;
        constraints.gridwidth = 5;
        add(B, constraints);

        //Przycisko uruchamiający walidację
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 8;
        add(przycisk, constraints);

        //Pole błędu/sukcesu
        constraints.gridy = 5;
        add(Wynik, constraints);
        

        // Rozmiar głównego okna
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Metoda do walidacji formularza
    private void Oblicz() {
        try {  
            Double s_A =  Double.parseDouble(A.getText());
            Double s_B = Double.parseDouble(B.getText());

            if(s_B == 0) {
                JOptionPane.showMessageDialog(getContentPane(),"Nie można dzielic przez 0");
            }else{
            double Dzielenie = s_A / s_B;
            success_mess("Wynik: "+Dzielenie);
            }
          } catch(NumberFormatException e){  
            error_mess("Podaj wartosci liczbowe!");
        }  


    }

    // Metoda do wyświetlania błędnych komunikatów
    private void error_mess(String wiadomosc) {
        Wynik.setText(wiadomosc);
        Wynik.setForeground(Color.RED);
    }

    // Metoda do wyświetlania komunikatów o sukcesie
    private void success_mess(String wiadomosc) {
        Wynik.setText(wiadomosc);
        Wynik.setForeground(Color.GREEN);
    }

    // Klasa do obsługi zmiany stanu komponentu (zmiana koloru)
    private class zmiana_stanu implements FocusListener {
        private JTextField field;

        public zmiana_stanu(JTextField field) {
            this.field = field;
        }

        @Override
        public void focusGained(FocusEvent e) {
            field.setBackground(new Color(125, 125, 125, 255)); // Zmień kolor tła po uzyskaniu fokusu
        }

        @Override
        public void focusLost(FocusEvent e) {
            field.setBackground(Color.DARK_GRAY); // Powrót do koloru tła ciemnoszarego po utraceniu fokusu
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main1 app = new Main1();
            app.setVisible(true);
        });
    }
}