// package java_programs.src;

import java.awt.*; // older graphics packages
import java.awt.event.*;

public class Conversion_EUR_USD extends Frame implements ActionListener, KeyListener, WindowListener {
  Button b1 = new Button("Botó 1");
  Button b2 = new Button("Botó 2");
  TextField t_EUR = new TextField(20);
  TextField t_USD = new TextField(20);

  public static void main(String[] args) throws Exception {
    new Conversion_EUR_USD();
  }

  Conversion_EUR_USD() {
    super("Conversion_EUR_USD"); // crida al constructor de la classe pare.
    setLayout(new FlowLayout());
    add(t_EUR);
    t_EUR.addKeyListener(this);
    add(b1);
    b1.addActionListener(this);
    add(b2);
    b2.addActionListener(this);
    add(t_USD);
    t_USD.addKeyListener(this);
    setVisible(true);
    setSize(500, 500);
    addWindowListener(this);
  }

  void EUR_to_USD() {
    double d, EUR_to_USD = 0.99;
    d = Double.parseDouble(t_EUR.getText());
    t_USD.setText(Double.toString(d * EUR_to_USD));
  }

  void USD_to_EUR() {
    double d, EUR_to_USD = 0.99;
    d = Double.parseDouble(t_USD.getText());
    t_EUR.setText(d / EUR_to_USD + ""); // other way instead of DOuble.toString
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == b1) {
      try {
        EUR_to_USD();
      } catch (NumberFormatException e) {
        t_USD.setText("");
      }
    } else if (arg0.getSource() == b2) {
      try {
        USD_to_EUR();
      } catch (NumberFormatException e) {
        t_EUR.setText("");
      }
    }
  }

  @Override
  public void keyPressed(KeyEvent arg0) {

  }

  @Override
  public void keyReleased(KeyEvent arg0) {
    if (arg0.getSource() == t_EUR) {
      try {
        EUR_to_USD();
      } catch (NumberFormatException e) {
        t_USD.setText("");
      }
    } else {
      try {
        USD_to_EUR();
      } catch (NumberFormatException e) {
        t_EUR.setText("");
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
  }

  @Override
  public void windowActivated(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosed(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing(WindowEvent arg0) {
    // dispose(); // Tanca només la finestra actual.
    System.exit(0);
  }

  @Override
  public void windowDeactivated(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowIconified(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowOpened(WindowEvent arg0) {
    // TODO Auto-generated method stub

  }
}
