package client.gui;

import client.controller.OrderController;
import library.dto.OrderDTO;

import javax.swing.*;

public class OrderFrame extends JFrame {

    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField typePackageField;
    private JTextField weightField;
    private JButton placeButton;
    private JLabel mainLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel typePackegeLabel;
    private JLabel weightLabel;

    public OrderFrame(){

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Place your orders: ");

        placeButton.addActionListener(ev -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String typePackage = typePackageField.getText();
            String weight = weightField.getText();
            OrderDTO orderDTO = new OrderDTO(0, name, address, typePackage, weight);

            try{
                int id = OrderController.getInstance().placeOrder(orderDTO);
                JOptionPane.showMessageDialog(null, "Your order with id #" + id + " has been placed!");
                new OrderFrame();
                dispose();
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Your order cannot be processed!");
            }
        });


    }
}
