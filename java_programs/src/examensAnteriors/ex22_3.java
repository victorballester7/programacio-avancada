package examensAnteriors;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class ex22_3 {
  public static void main(String[] args) {
    new Finestra();
  }

  public static class Finestra extends JFrame {
    public static final int width = 500, height = 500;
    public Joc j;
    public JPanel panel;

    Finestra() {
      new JFrame();
      setTitle("Persona que camina"); // Name of the window
      setSize(width, height);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // use x button to close the window
      setLocationRelativeTo(null); // centers the window on the screen
      // frame.setResizable(false); // prevent the window to be resizable
      j = new Joc(this);
      panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
          super.paintComponent(g);
          j.pintar(g);
        }
      };
      setContentPane(panel);
      pack();
      setVisible(true); // activates the visibility
      j.run();
    }

  }

  public static class Joc {
    Personatge p;
    public int delay = 100; // in milliseconds
    private Finestra f;

    Joc(Finestra f) {
      this.f = f;
      p = new Personatge(4);
    }

    public void run() {
      while (true) {
        doStep();
        p.steps++;
        System.out.println(p.steps);
      }
    }

    public void pintar(Graphics g) {
      p.pintarPersonatge(g);
      g.drawString("Passes: " + p.steps, 0, 0);
    }

    public void doStep() {
      for (int i = 0; i < p.numImg; i++) {
        p.updatePersonatge(i);
        f.repaint();
        try {
          Thread.sleep(delay);
        } catch (InterruptedException e) {
          System.out.println(e);
        }
      }
    }
  }

  public static class Personatge {
    public int numImg = 4;
    public BufferedImage[] img = new BufferedImage[numImg];
    public BufferedImage actualImg = null;
    public int steps = 0;

    Personatge(int numImg) {
      this.numImg = numImg;
      try {
        for (int i = 0; i < numImg; i++)
          img[i] = ImageIO.read(new File("java_programs/src/examensAnteriors/" + (i +
              1) + ".jpg"));
        actualImg = img[0];
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void updatePersonatge(int i) {
      actualImg = img[i];
    }

    public void pintarPersonatge(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(actualImg, 0, 0, null);
    }
  }

}
