package main.CardsGUI;

import javax.swing.*;

import javax.swing.*;
public class ButtonExample{
    ButtonExample(){
        JFrame f=new JFrame("Button Example");
        JButton b=new JButton(new ImageIcon("C:\\Users\\minda\\Downloads\\icon.jpg"));
        b.setBounds(70,150,100, 56);
        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1;
        l1=new JLabel("Welcome");
        l1.setBounds(100,100, 100,30);
        f.add(l1);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new ButtonExample();
    }
}
