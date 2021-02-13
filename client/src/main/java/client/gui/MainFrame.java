package client.gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JButton clientButton;
    private JButton courierButton;
    private JPanel mainPanel;
    private JLabel mainLabel;

    public MainFrame(){
        setTitle("Delivery Application");
        setSize(500, 500);

        mainLabel = new JLabel("WELCOME!!!");

        clientButton.addActionListener(e -> {
            dispose();
            new LoginUserFrame();
        });
        courierButton.addActionListener(e -> {
            dispose();
            new LoginUserFrame();
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
