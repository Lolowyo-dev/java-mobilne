import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Checki extends JFrame {
    private JRadioButton kobietaRadio;
    private JRadioButton mezczyznaRadio;
    private JCheckBox check1;
    private JCheckBox check2;
    private JCheckBox check3;
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

        check1 = new JCheckBox("Latanie");
        check1.setFont(new Font("Arial", Font.PLAIN, 20));
        check1.setForeground(Color.WHITE);
        check1.setOpaque(false);

        check2 = new JCheckBox("Kopanie");
        check2.setFont(new Font("Arial", Font.PLAIN, 20));
        check2.setForeground(Color.WHITE);
        check2.setOpaque(false);

        check3 = new JCheckBox("Spadanie");
        check3.setFont(new Font("Arial", Font.PLAIN, 20));
        check3.setForeground(Color.WHITE);
        check3.setOpaque(false);

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
        constraints.gridwidth = 1;
        add(kobietaRadio, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(mezczyznaRadio, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(check1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        add(check2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        add(check3, constraints);

        

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
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
        String[] hobby = new String[3];
        String hobby_txt = "";

        if(check1.isSelected())
        hobby[0] = check1.getText();
                
        if(check2.isSelected())
        hobby[1] = check2.getText();
                
        if(check3.isSelected())
        hobby[2] = check3.getText();

        for (String hoby : hobby) {
            hobby_txt+=hoby+" ";
        }

        if (!kobietaRadio.isSelected() && !mezczyznaRadio.isSelected()) {
            error_mess("Ustaw płeć.");
        } else {
            success_mess("Formularz wysłany poprawnie !");
            JOptionPane.showMessageDialog(getContentPane(),"Płeć: "+plecText+"\nHobby: "+hobby_txt);
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
