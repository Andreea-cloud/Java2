package client.gui;

import javax.swing.*;

public class OrderFrame extends JFrame {

    private JPanel mainPanel;

    public OrderFrame(){

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        setTitle("Order List");


    }
}
