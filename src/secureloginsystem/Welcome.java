package secureloginsystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Welcome extends JFrame {
    public Welcome(String name, String regNumber) {
        setTitle("Welcome");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.cyan);

        JLabel welcomeLabel = new JLabel("Welcome, " + name + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(welcomeLabel);

        JLabel regNumberLabel = new JLabel("Registration Number: " + regNumber, SwingConstants.CENTER);
        regNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(regNumberLabel);

        JButton btnLogout = new JButton("you may log out");
        btnLogout.addActionListener(e -> {
            dispose();
        });
        panel.add(btnLogout);

        add(panel);
        setVisible(true);
    }
}
