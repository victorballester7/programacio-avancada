package java_programs.src;

import java.awt.*;
import javax.swing.JFrame;

public class FinestraXY {
  public static void main(String[] args) {
    JFrame f = new JFrame("Finestra");
    f.setLayout(null);
    Button b = new Button("Botó");
    f.add(b);
    f.setSize(800, 800);
    f.setVisible(true);
    b.setBounds(100, 100, b.getPreferredSize().width, b.getPreferredSize().height);
  }
}
