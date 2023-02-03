package examensAnteriors;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

public class ex22_32 {
  public static void main(String[] args) {
    new Finestra();
  }

  public static class Finestra extends JFrame {
    Joc j;
    JPanel panel;
    Graphics g;
    int ALÇADA = 800, AMPLADA = 800;

    Finestra() {
      super();
      setTitle("F1 game"); // Name of the window
      setSize(AMPLADA, ALÇADA);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // use x button to close the window
      setLocationRelativeTo(null); // centers the window on the screen
      // frame.setResizable(false); // prevent the window to be resizable
      j = new Joc(this);
      panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
          super.paintComponent(g);
        }
      };
      setContentPane(panel);
      setVisible(true);
      g = getGraphics();
      j.run();
    }
  }

  public static class Joc {
    Finestra f;
    Personatge p;
    // int y;

    public Joc(Finestra f) {
      this.f = f;
      p = new Personatge(4, 300, 300);
    }

    public void run() {
      while (true) {
        moureElement();// moure els objectes de pantalla
        repintarPantalla(f.g);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    private void moureElement() {
      p.updatePersonatge(f);
      // p.moute();
    }

    private void repintarPantalla(Graphics g) {
      p.pintarPersonatge(g);
      g.drawString("Passes: " + p.steps, 10, 30);
      f.repaint();
    }
  }

  public static class Personatge {
    public int numImg = 4;
    public BufferedImage[] img = new BufferedImage[numImg];
    public BufferedImage actualImg = null;
    public AffineTransform at;
    public int index = 0;
    public int steps = 0;
    public int x, y;

    public Personatge(int numImg, int x, int y) {
      this.numImg = numImg;
      this.x = x;
      this.y = y;
      try {
        for (int i = 0; i < numImg; i++)
          img[i] = ImageIO.read(new File("java_programs/src/examensAnteriors/" + (i + 1) + ".jpg"));
        actualImg = img[index];
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void updatePersonatge(Finestra f) {
      index++;
      if (index == 4) {
        index = 0;
        steps++;
      }
      actualImg = img[index];
      at = applyTransform(actualImg, f);
    }

    public void moure() {

    }

    public AffineTransform applyTransform(BufferedImage img, Finestra f) {
      double ratioX = f.getWidth() / 2 * 1. / img.getWidth();
      double ratioY = f.getHeight() / 2 * 1. / img.getHeight();
      AffineTransform at = new AffineTransform();
      at.translate(x, y);
      // at2.rotate(rotationAngle + initialSteeringAngle);
      at.scale(ratioX, ratioY);
      at.translate(-img.getWidth() / 2, -img.getHeight() / 2);
      return at;
    }

    public void pintarPersonatge(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(actualImg, at, null);
    }
  }

}
