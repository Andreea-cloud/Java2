package client.gui;

import client.controller.OrderController;
import library.dto.OrderDTO;

import javax.swing.*;

public class RegisteredOrdersFrame extends JFrame {

    private JPanel mainPanel;
    private JLabel mainLabel;
    private JTextField textField;
    private JButton chooseButton;
    private JLabel chooseLabel;

    public RegisteredOrdersFrame(){
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Orders list");

        chooseButton.addActionListener(ev -> {
            int id = Integer.parseInt(textField.getText());
            OrderDTO orderDTO = new OrderDTO(id, "", "", "", "");

            try{
                OrderController.getInstance().deleteOrder(orderDTO);
                JOptionPane.showMessageDialog(null, "Your selected to deliver order with id: #" + id);
                new RegisteredOrdersFrame();
                dispose();
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Your order cannot be processed!");
            }
        });
    }
}
