import java.awt.*; 
import javax.swing.*;


public class Main{
    private static void createWindow() { 
        JFrame frame = new JFrame("Bondziorno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel1 = new JLabel("Juan",SwingConstants.CENTER); 
        textLabel1.setPreferredSize(new Dimension(800, 200));
        frame.getContentPane().add(textLabel1, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) { 
        createWindow(); 
    }
}