package client.gui;

import client.controller.ClientController;
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

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(ev -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            ClientDTO clientDTO = new ClientDTO(0, username, password);

            try{
                new OrderFrame();
                dispose();
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        registerButton.addActionListener(ev -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            ClientDTO clientDTO = new ClientDTO(0, username, password);

            try{
                int id = ClientController.getInstance().register(clientDTO);
                JOptionPane.showMessageDialog(null, "Congratulations! Your ID is " + id);
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Username already registered! Please choose another: ");
                passwordField.setText("");
                usernameField.setText("");
            }
        });
    }
}
