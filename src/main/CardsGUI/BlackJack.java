package main.CardsGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlackJack {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

    public BlackJack(){
        prepareGUI();
    }
    public static void main(String[] args){
        BlackJack swingLayoutDemo = new BlackJack();
        swingLayoutDemo.showCardLayoutDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("1000 CardGame");
        mainFrame.setSize(1000,1000);
        mainFrame.setLayout(new GridLayout(4, 1));


        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showCardLayoutDemo(){
        headerLabel.setText("Welcome to the game!");
//        headerLabel.setText("<html><h1>Heading</h1><br/>Some other text here.</html>");
//        headerLabel.setFont(new Font("Myriad Pro",Font.PLAIN,15));

        final JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(300,300);

        CardLayout layout = new CardLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);

        JButton b=new JButton(new ImageIcon("C:\\Users\\minda\\Downloads\\icon.jpg"));
        b.setBounds(70,150,100, 56);
        mainFrame.add(b);
//        mainFrame.setSize(300,400);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(new JButton("OK"));
        buttonPanel.add(new JButton("Cancel"));

        JPanel textBoxPanel = new JPanel(new FlowLayout());
        textBoxPanel.add(new JLabel("Name:"));
        textBoxPanel.add(new JTextField(20));

        panel.add("Button", buttonPanel);
        panel.add("Text", textBoxPanel);
        final DefaultComboBoxModel panelName = new DefaultComboBoxModel();

        panelName.addElement("Button");
        panelName.addElement("Text");
        final JComboBox listCombo = new JComboBox(panelName);

        listCombo.setSelectedIndex(0);
        JScrollPane listComboScrollPane = new JScrollPane(listCombo);
        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (listCombo.getSelectedIndex() != -1) {
                    CardLayout cardLayout = (CardLayout)(panel.getLayout());
                    cardLayout.show(panel,
                            (String)listCombo.getItemAt(listCombo.getSelectedIndex()));
                }
                statusLabel.setText(data);
            }
        });
        controlPanel.add(listComboScrollPane);
        controlPanel.add(showButton);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
}