package PAM.zad7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormValidationApp extends JFrame {
    private JTextField imie;
    private JTextField nazwisko;
    private JTextField mail;
    private JLabel validacja;

    public FormValidationApp() {
        setTitle("Form Validation");
        setLayout(new FlowLayout());
        setBackground(Color.BLACK); // Ustawienie tła na czarne

        // Inicjalizacja pól tekstowych
        imie = new JTextField(20);
        nazwisko = new JTextField(20);
        mail = new JTextField(20);
        
        JButton przycisk = new JButton("Wyślij");
        validacja = new JLabel();

        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateForm();
            }
        });

        // Dodanie etykiet i komponentów do interfejsu użytkownika
        add(new JLabel("Imię: "));
        add(imie);
        add(new JLabel("Nazwisko: "));
        add(nazwisko);
        add(new JLabel("E-mail: "));
        add(mail);
        add(przycisk);
        add(validacja);

        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Metoda do walidacji formularza
    private void validateForm() {
        String s_imie = imie.getText();
        String s_nazwisko = nazwisko.getText();
        String s_mail = mail.getText();

        if (s_imie.isEmpty()) {
            error_mess("Wpisz imię.");
        } else if (s_nazwisko.isEmpty()) {
            error_mess("Wpisz nazwisko.");
        } else if (!validacja_mail(s_mail)) {
            error_mess("Zły adres e-mail.");
        } else {
            success_mess("Formularz wysłany!");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormValidationApp app = new FormValidationApp();
            app.setVisible(true);
        });
    }
}
