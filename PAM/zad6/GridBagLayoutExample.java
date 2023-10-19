import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample extends JFrame {
    public GridBagLayoutExample() {
        setTitle("GridBagLayout Example");
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridwidth = 2;
        JLabel label1 = new JLabel("Label 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(label1, constraints);
        

        JLabel label2 = new JLabel("Label 2");
        constraints.gridx = 2;
        constraints.gridy = 0;
        add(label2, constraints);
        constraints.gridwidth = 1;

        JLabel label3 = new JLabel("Label 3");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(label3, constraints);

        JLabel label4 = new JLabel("Label 4");
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(label4, constraints);
        JLabel label5 = new JLabel("Label 5");
        constraints.gridx = 2;
        constraints.gridy = 1;
        add(label5, constraints);
        JLabel label6 = new JLabel("Label 6");
        constraints.gridx = 3;
        constraints.gridy = 1;
        add(label6, constraints);



        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridBagLayoutExample example = new GridBagLayoutExample();
            example.setVisible(true);
        });
    }
}
