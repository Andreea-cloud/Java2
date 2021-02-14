package client.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JButton clientButton;
    private JButton courierButton;
    private JPanel mainPanel;
    private JLabel mainLabel;

    public MainFrame(){
        setTitle("Delivery Application");

        clientButton.addActionListener(e -> {
            new LoginClientFrame();
            dispose();
        });
        courierButton.addActionListener(e -> {
            new LoginUserFrame();
            dispose();
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
