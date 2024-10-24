package secureloginsystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JDialog {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private List<User> users;

    public Login(Signup parent, List<User> users) {
        super(parent);
        this.users = users;
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.CYAN);
        setContentPane(panel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 10);


        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        txtUsername.setBackground(Color.PINK);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsername.setToolTipText("Enter your username");
        panel.add(txtUsername, gbc);

        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        txtPassword.setBackground(Color.PINK);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(txtPassword, gbc);

        btnLogin = new JButton("Login");
        panel.add(btnLogin, gbc);


        btnCancel = new JButton("Cancel");
        panel.add(btnCancel, gbc);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();
                if (login(username, password)) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                new Welcome(user.getName(), user.getRegNumber());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // For testing purposes
        SwingUtilities.invokeLater(() -> {
            new Login(null, List.of(new User("test", "testUser", "12345", "password")));
        });
    }
}