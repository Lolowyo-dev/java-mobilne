import java.awt.*; 
import javax.swing.*;


public class Main{
    private static void createWindow() { 
        JFrame frame = new JFrame("Bondziorno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel1 = new JLabel("Juan",SwingConstants.CENTER); 
        JLabel textLabel2 = new JLabel("Guan",SwingConstants.CENTER); 
        JLabel textLabel3 = new JLabel("Buan",SwingConstants.CENTER); 
        textLabel1.setPreferredSize(new Dimension(800, 200));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) { 
        createWindow(); 
    }
}