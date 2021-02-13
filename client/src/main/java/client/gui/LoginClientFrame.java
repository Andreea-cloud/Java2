package client.gui;

import library.dto.ClientDTO;

import javax.swing.*;

public class LoginClientFrame extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginClientFrame(){
        setTitle("Login/Register");
        setSize(700, 700);

        mainLabel = new JLabel("Please enter your details: ");
        usernameLabel =new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        loginButton.addActionListener(ev -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            ClientDTO clientDTO = new ClientDTO(0, username, password);

            try{
                dispose();
                new OrderFrame();
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }
}
