package Exp15;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Code2_Buttons extends JFrame implements ActionListener {
    Container c;
    JButton btnHi, btnHowareyou, btnPrerna, btnGladtomeet;
    JLabel label;

    Code2_Buttons() {
        c = getContentPane();
        c.setLayout(null);
        btnHi = new JButton("Hi");
        btnPrerna = new JButton("Prerna");
        btnGladtomeet = new JButton("Glad to meet");
        btnHowareyou = new JButton("How are you?");
        label = new JLabel(" ");
        label.setSize(200, 60);
        btnHi.setLocation(100, 50);
        btnPrerna.setLocation(100, 110);
        btnGladtomeet.setLocation(100, 170);
        btnHowareyou.setLocation(100, 230);
        btnHi.setSize(100, 50);
        btnPrerna.setSize(100, 50);
        btnGladtomeet.setSize(100, 50);
        btnHowareyou.setSize(100, 50);
        c.add(btnHi);
        c.add(btnPrerna);
        c.add(btnGladtomeet);
        c.add(btnHowareyou);
        c.add(label);
        btnHi.addActionListener(this);
        btnPrerna.addActionListener(this);
        btnGladtomeet.addActionListener(this);
        btnHowareyou.addActionListener(this);
    }

    public static void main(String[] args) {
        Code2_Buttons frm = new Code2_Buttons();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(200, 200, 400, 500);
        frm.setVisible(true);
        frm.setTitle("click me");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHi) {
            label.setText("Hi");
            label.setLocation(220, 50);
        }
        if (e.getSource() == btnPrerna) {
            label.setText("Prerna?");
            label.setLocation(220, 110);
        }
        if (e.getSource() == btnGladtomeet) {
            label.setText("Glad to meet");
            label.setLocation(220, 160);
        }
        if (e.getSource() == btnHowareyou) {
            label.setText("How are you");
            label.setLocation(220, 230);
        }
    }
}