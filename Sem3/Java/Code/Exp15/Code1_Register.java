package Exp15;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Code1_Register extends JFrame implements ActionListener {
    Container c;
    JLabel name, street, city, pincode;
    JTextField tname, tstreet, tcity, tpincode;
    JTextArea tout;
    JButton MyInfo, btnClear, btnExit;
    String sname, sstreet, scity, spincode;

    Code1_Register() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        // label
        name = new JLabel("Name: ");
        street = new JLabel("street:");
        city = new JLabel("city: ");
        pincode = new JLabel("pincode: ");
        // text fields
        tname = new JTextField(10);
        tstreet = new JTextField(10);
        tcity = new JTextField(10);
        tpincode = new JTextField(6);
        // buttons
        MyInfo = new JButton("Display");
        c.add(name);
        c.add(tname);
        c.add(street);
        c.add(tstreet);
        c.add(city);
        c.add(tcity);
        c.add(pincode);
        c.add(tpincode);
        c.add(MyInfo);
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.ITALIC, 32));
        tout.setSize(300, 400);
        tout.setLocation(100, 500);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
        MyInfo.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MyInfo) {
            sname = tname.getText();
            scity = tcity.getText();
            sstreet = tstreet.getText();
            spincode = tpincode.getText();
            if (sname.equals("") || sstreet.equals("") ||
                    scity.equals("") ||
                    spincode.equals("")) {
                JOptionPane.showMessageDialog(c, "Input field is empty !!");
                tname.requestFocus();
            } else {
                String data = "Name : " + tname.getText() + "\n" +
                        "Street : " + tstreet.getText() + "\n" + "City : "
                        + tcity.getText() + "\n" + "Pincode : " +
                        tpincode.getText() + "\n";
                tout.setText(data);
                tout.setEditable(false);
            }
        } else if (e.getSource() == btnClear) {
            tname.setText("");
            tpincode.setText("");
            tstreet.setText("");
            tcity.setText("");
            tname.requestFocus();
        } else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Code1_Register frm = new Code1_Register();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(200, 200, 400, 300);
        frm.setVisible(true);
        frm.setTitle("REGISTER");
    }
}
