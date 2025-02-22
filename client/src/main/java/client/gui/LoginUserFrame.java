package client.gui;

import client.controller.UserController;
import library.dto.UserDTO;

import javax.swing.*;

public class LoginUserFrame extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LoginUserFrame(){

        setTitle("Login/Register");

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(ev -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            UserDTO userDTO = new UserDTO(0, username, password);

            try{
                int id = UserController.getInstance().login(userDTO);
                JOptionPane.showMessageDialog(null, "Successful logged in!");
                new RegisteredOrdersFrame();
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
            UserDTO userDTO = new UserDTO(0, username, password);

            try{
                int id = UserController.getInstance().register(userDTO);
                JOptionPane.showMessageDialog(null, "Congratulations! Your id is " + id);
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Username already registered! Please choose another: ");
                passwordField.setText("");
                usernameField.setText("");
            }
        });
    }
}
