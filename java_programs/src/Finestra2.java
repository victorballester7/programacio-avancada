package java_programs.src;

import java.awt.*; // older graphics packages
import java.awt.event.*;
//import java.swing; // newer graphics packages

public class Finestra2 implements ActionListener {
  Button b1 = new Button("Botó 1");
  Button b2 = new Button("Botó 2");
  TextField t = new TextField(20);

  public static void main(String[] args) throws Exception {
    new Finestra2();
  }

  Finestra2() {
    Frame f = new Frame("Finestra");
    f.setLayout(new FlowLayout());
    f.add(t);
    f.add(b1);
    f.add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
    f.setVisible(true);
    f.setSize(500, 500);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == b1)
      System.out.println(t.getText());
    else if (arg0.getSource() == b2)
      System.out.println("Botó 2 premut");
  }
}
