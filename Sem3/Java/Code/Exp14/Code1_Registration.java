package Exp14;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Code1_Registration extends JFrame implements ActionListener {
    Container c;
    JLabel lFName, lLName, lPassword, lEmail;
    JTextField txtFName, txtLName;
    JTextField txtEmail;
    JPasswordField txtPassword;
    JButton btnSubmit, btnClear, btnExit;
    String strFName, strLName, strPassword, strEmail;
    Code1_Registration() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        lFName = new JLabel("First Name: ");
        lLName = new JLabel("Last Name: ");
        lPassword = new JLabel("Password: ");
        lEmail = new JLabel("Email: ");
        txtFName = new JTextField(10);
        txtLName = new JTextField(10);
        txtEmail = new JTextField(10);
        txtPassword = new JPasswordField(10);
        txtPassword.setEchoChar('*');
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        c.add(lFName);
        c.add(txtFName);
        c.add(lLName);
        c.add(txtLName);
        c.add(lEmail);
        c.add(txtEmail);
        c.add(lPassword);
        c.add(txtPassword);
        c.add(btnSubmit);
        c.add(btnClear);
        c.add(btnExit);
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSubmit) {
            strLName = txtLName.getText();
            strFName = txtFName.getText();
            // strPassword = txtPassword.getText();
            strEmail = txtEmail.getText();
            if (strFName.equals("") || strLName.equals("") ||
                    strPassword.equals("") ||
                    strEmail.equals("")) {
                JOptionPane.showMessageDialog(c, "Input field is empty!!");
                txtFName.requestFocus();
            } else {
                JOptionPane.showMessageDialog(c, "Your account is created ");
                txtFName.setText("");
                txtPassword.setText("");
                System.exit(0);
            }
        } else if (ae.getSource() == btnClear) {
            txtFName.setText("");
            txtPassword.setText("");
            txtLName.setText("");
            txtEmail.setText("");
            txtFName.requestFocus();
        } else {
            
            System.exit(0);
        }
    }
    public static void main(String z[]) {
        //Prerna Sunil Jadhav - 60004221027
        Code1_Registration frm = new Code1_Registration();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(200, 200, 400, 300);
        frm.setVisible(true);
        frm.setTitle("REGISTER");
    }
}
