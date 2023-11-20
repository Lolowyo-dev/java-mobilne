package PAM.zad7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FormValidationApp extends JFrame {
    private JTextField imie;
    private JTextField nazwisko;
    private JTextField mail;
    private JRadioButton kobietaRadio;
    private JRadioButton mezczyznaRadio;
    private JLabel validacja;

    public FormValidationApp() {
        // Tytuł okna
        setTitle("Form Validation");

        // Ustawienie układu na GridBagLayout dla lepszego rozmieszczenia komponentów
        setLayout(new GridBagLayout());

        // Ustawienie koloru tła głównego okna
        getContentPane().setBackground(new Color(53, 55, 64, 255));

        // Konfiguracja ograniczeń układu GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Odstęp między komponentami

        // Inicjalizacja pól tekstowych
        imie = new JTextField(20);
        nazwisko = new JTextField(20);
        mail = new JTextField(15);

        // Stylizacja i konfiguracja pola tekstowego "Imię"
        imie.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Biały obramowanie
        imie.setForeground(Color.WHITE); // Kolor tekstu biały
        imie.addFocusListener(new zmiana_stanu(imie)); // Dodanie obsługi zmiany stanu (dla efektu zmiany koloru)
        imie.setFont(new Font("Arial", Font.PLAIN, 20)); // Ustawienie czcionki

        // Stylizacja i konfiguracja pola tekstowego "Nazwisko"
        nazwisko.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        nazwisko.setBackground(Color.DARK_GRAY);
        nazwisko.setForeground(Color.WHITE);
        nazwisko.addFocusListener(new zmiana_stanu(nazwisko));
        nazwisko.setFont(new Font("Arial", Font.PLAIN, 20));

        // Stylizacja i konfiguracja pola tekstowego "E-mail"
        mail.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        mail.setBackground(Color.DARK_GRAY);
        mail.setForeground(Color.WHITE);
        mail.addFocusListener(new zmiana_stanu(mail));
        mail.setFont(new Font("Arial", Font.PLAIN, 20));

        // Inicjalizacja przycisków typu RadioButton
        kobietaRadio = new JRadioButton("Kobieta");
        kobietaRadio.setFont(new Font("Arial", Font.PLAIN, 20)); // Ustawienie czcionki
        kobietaRadio.setForeground(Color.WHITE); // Kolor tekstu biały
        kobietaRadio.setOpaque(false); // Przezroczyste tło

        mezczyznaRadio = new JRadioButton("Mężczyzna");
        mezczyznaRadio.setFont(new Font("Arial", Font.PLAIN, 20));
        mezczyznaRadio.setForeground(Color.WHITE);
        mezczyznaRadio.setOpaque(false);

        // Grupa przycisków typu RadioButton
        ButtonGroup grupaPlec = new ButtonGroup();
        grupaPlec.add(kobietaRadio);
        grupaPlec.add(mezczyznaRadio);

        // Inicjalizacja przycisku "Wyślij"
        JButton przycisk = new JButton("Wyślij");
        przycisk.setFont(new Font("Arial", Font.BOLD, 18)); // Zmień czcionkę przycisku na pogrubioną
        przycisk.setBackground(new Color(55, 55, 55, 255)); // Zmień kolor tła przycisku
        przycisk.setForeground(Color.BLACK); // Zmień kolor tekstu przycisku
        przycisk.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Dodaj czarny obramowanie przycisku

        // Inicjalizacja etykiety "validacja"
        validacja = new JLabel();
        validacja.setForeground(Color.WHITE); // Kolor tekstu biały
        validacja.setFont(new Font("Arial", Font.PLAIN, 18)); // Ustawienie czcionki

        // Inicjalizacja validacji po kliknięciu w przycisk
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateForm();
            }
        });

        // Stylizacja czcionki dla etykiet
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Map<TextAttribute, Object> fontAttributes = new HashMap<>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labelFont = labelFont.deriveFont(fontAttributes);
        validacja.setFont(labelFont);

        //Label to pola tekstowego imie
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        JLabel imieLabel = new JLabel("Imię: ");
        imieLabel.setForeground(Color.WHITE);
        imieLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(imieLabel, constraints);

        //pole tekstowe imie
        constraints.gridx = 3;
        constraints.gridwidth = 5;
        add(imie, constraints);

        //Label to pola tekstowego nazwisko
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        JLabel nazwiskoLabel = new JLabel("Nazwisko: ");
        nazwiskoLabel.setForeground(Color.WHITE);
        nazwiskoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(nazwiskoLabel, constraints);

        //pole tekstowe nazwisko
        constraints.gridx = 3;
        constraints.gridwidth = 5;
        add(nazwisko, constraints);

        //Label to pola tekstowego mail
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        JLabel mailLabel = new JLabel("E-mail: ");
        mailLabel.setForeground(Color.WHITE);
        mailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(mailLabel, constraints);

        //pole tekstowe mail
        constraints.gridx = 2;
        add(mail, constraints);

        //pole radio
        constraints.gridx = 4;
        add(kobietaRadio, constraints);
        //pole radio
        constraints.gridx = 6;
        add(mezczyznaRadio, constraints);

        //Przycisko uruchamiający walidację
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 8;
        add(przycisk, constraints);

        //Pole błędu/sukcesu
        constraints.gridy = 4;
        add(validacja, constraints);

        // Rozmiar głównego okna
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Metoda do walidacji formularza
    private void validateForm() {
        String s_imie = imie.getText();
        String s_nazwisko = nazwisko.getText();
        String s_mail = mail.getText();
        String plecText = kobietaRadio.isSelected() ? "Kobieta" : "Mężczyzna";

        if (s_imie.isEmpty()) {
            error_mess("Wpisz imię.");
        } else if (s_nazwisko.isEmpty()) {
            error_mess("Wpisz nazwisko.");
        } else if (!validacja_mail(s_mail)) {
            error_mess("Zły adres e-mail.");
        } else if (!kobietaRadio.isSelected() && !mezczyznaRadio.isSelected()) {
            error_mess("Ustaw płeć.");
        } else {
            success_mess("Formularz wysłany jako " + plecText + "!");
        }
    }

    // Prosta walidacja e-mail
    private boolean validacja_mail(String s_mail) {
        return s_mail.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Metoda do wyświetlania błędnych komunikatów
    private void error_mess(String wiadomosc) {
        validacja.setText(wiadomosc);
        validacja.setForeground(Color.RED);
    }

    // Metoda do wyświetlania komunikatów o sukcesie
    private void success_mess(String wiadomosc) {
        validacja.setText(wiadomosc);
        validacja.setForeground(Color.GREEN);
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
            FormValidationApp app = new FormValidationApp();
            app.setVisible(true);
        });
    }
}
