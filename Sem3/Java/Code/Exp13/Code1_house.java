package Exp13;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Code1_house {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setTitle("House");
        jf.setSize(300, 300);
        jf.setLocation(300, 100);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel() {
            public void paint(Graphics g) {
                g.drawString("Prerna Sunil Jadhav - 60004220127", 250, 250);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(20, 80, 60, 70);
                g.setColor(Color.RED);
                g.fillRect(80, 80, 90, 70);
                g.setColor(Color.PINK);
                g.fillRect(60, 90, 10, 10);
                g.setColor(Color.yellow);
                g.fillRect(40, 110, 20, 40);
                g.setColor(Color.BLACK);
                g.drawLine(50, 50, 150, 50);
                g.setColor(Color.GRAY);
                g.drawLine(150, 50, 171, 83);
                g.drawLine(110, 50, 131, 83);
                g.drawLine(130, 50, 151, 83);
                g.drawLine(90, 50, 111, 83);
                g.drawLine(70, 50, 91, 83);
                g.setColor(Color.BLACK);
                g.drawLine(80, 80, 170, 80);
                g.setColor(Color.GREEN);
                g.fillRect(110, 100, 30, 30);
                g.setColor(Color.BLUE);
                g.fillPolygon(new int[] { 50, 20, 80 }, new int[] { 50, 80,80 }, 3);
            }
        };
        jf.add(p);
    }
}
