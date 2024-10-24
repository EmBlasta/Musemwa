package secureloginsystem;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Signup extends JDialog {
    private JTextField txtName;
    private JTextField txtUsername;
    private JTextField txtRegNumber;
    private JPasswordField txtPassword;
    private JButton btnSignUp;
    private JPanel panel;
    private List<User> users;
    private JButton btnLogin;

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Sign Up");
        setSize(600, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        users = new ArrayList<>();

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.CYAN);
        setContentPane(panel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        txtName = new JTextField(15);
        txtName.setBackground(Color.PINK);
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(txtName);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        panel.add(txtName);
        txtUsername = new JTextField(15);
        txtUsername.setBackground(Color.PINK);
        txtUsername.setForeground(Color.BLACK);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsername.setToolTipText("Enter your username");
        panel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Registration Number:"), gbc);
        gbc.gridx = 1;
        txtRegNumber = new JTextField(15);
        txtRegNumber.setBackground(Color.PINK);
        txtRegNumber.setForeground(Color.BLACK);
        txtRegNumber.setFont(new Font("Arial", Font.PLAIN, 14));
        txtRegNumber.setToolTipText("Enter your registration number");
        panel.add(txtRegNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField();
        txtPassword.setBackground(Color.PINK);
        txtPassword.setForeground(Color.BLACK);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBackground(Color.ORANGE);
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        btnSignUp.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(btnSignUp, gbc);

        gbc.gridx = 1;
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.ORANGE);
        btnLogin.setForeground(Color.WHITE);
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(btnLogin, gbc);

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String regNumber = txtRegNumber.getText().trim();
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();

                if (name.isEmpty() || regNumber.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addUser(name, username, regNumber, password);
                    new Login(Signup.this, users);
                }
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(Signup.this, users);
            }
        });
        setVisible(true);
    }

    private void addUser(String name, String username, String regNumber, String password) {
        User newUser = new User(name, username, regNumber, password);
        users.add(newUser);

        JOptionPane.showMessageDialog(null, "User registered successfully!");
        clearInputFields();
    }

    private void clearInputFields() {
        txtName.setText("");
        txtUsername.setText("");
        txtRegNumber.setText("");
        txtPassword.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup(null));
    }
}
