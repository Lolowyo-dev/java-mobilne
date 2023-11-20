import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Checki extends JFrame {
    private JRadioButton kobietaRadio;
    private JRadioButton mezczyznaRadio;
    private JLabel validacja;

    public Checki() {
        // Tytuł okna
        setTitle("Form Validation");

        // Ustawienie układu na GridBagLayout dla lepszego rozmieszczenia komponentów
        setLayout(new GridBagLayout());

        // Ustawienie koloru tła głównego okna
        getContentPane().setBackground(new Color(53, 55, 64, 255));

        // Konfiguracja ograniczeń układu GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Odstęp między komponentami

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
        String plecText = kobietaRadio.isSelected() ? "Kobieta" : "Mężczyzna";

        if (!kobietaRadio.isSelected() && !mezczyznaRadio.isSelected()) {
            error_mess("Ustaw płeć.");
        } else {
            success_mess("Formularz wysłany jako " + plecText + "!");
        }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Checki app = new Checki();
            app.setVisible(true);
        });
    }
}
