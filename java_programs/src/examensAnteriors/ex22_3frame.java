package examensAnteriors;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import java.io.*;

public class ex22_3frame {
  public static void main(String[] args) {
    new Finestra();
  }

  public static class Finestra extends Frame {
    Joc j;
    Image im;
    Graphics g;
    int ALÇADA = 800, AMPLADA = 800;

    Finestra() {
      super("Joc");
      setSize(ALÇADA, AMPLADA);
      setVisible(true);
      im = createImage(ALÇADA, AMPLADA);
      g = im.getGraphics();
      j = new Joc(this);
      j.run();
    }

    public void paint(Graphics g) {
      g.drawImage(im, 0, 0, null);
    }

    public void update(Graphics g) {
      paint(g);
    }
  }

  public static class Joc {
    Finestra f;
    public int delay = 100; // in milliseconds
    Personatge p;

    public Joc(Finestra f) {
      this.f = f;
      p = new Personatge(4, 300, 300);
    }

    public void run() {
      // inicialització dels objectes del joc
      // y = 50;
      while (true) {
        moureElement();// moure els objectes de pantalla
        repintarPantalla();
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    private void moureElement() {
      p.updatePersonatge(f);
      // p.moute();
    }

    private void repintarPantalla() {
      p.pintarPersonatge(f.g);
      f.g.drawLine(0, 10, 300, 10);
      f.g.drawString("Passes: " + p.steps, 0, 0);
      f.repaint();
    }

    // public void run() {
    // while (true) {
    // doStep();
    // p.steps++;
    // System.out.println(p.steps);
    // }
    // }

    // public void pintar(Graphics g) {
    // p.pintarPersonatge(g);
    // g.drawString("Passes: " + p.steps, 0, 0);
    // }

    // public void doStep() {
    // for (int i = 0; i < p.numImg; i++) {
    // p.updatePersonatge(i);
    // f.repaint();
    // try {
    // Thread.sleep(delay);
    // } catch (InterruptedException e) {
    // System.out.println(e);
    // }
    // }
    // }
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
          img[i] = ImageIO.read(new File("java_programs/src/examensAnteriors/" + (i +
              1) + ".jpg"));
        actualImg = img[index];
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void updatePersonatge(Finestra f) {
      index++;
      if (index == 4)
        index = 0;
      actualImg = img[index];
      at = applyTransform(actualImg);
    }

    public void moure() {

    }

    public AffineTransform applyTransform(BufferedImage img) {
      double ratio = 0.3;
      AffineTransform at = new AffineTransform();
      at.translate(x, y);
      // at2.rotate(rotationAngle + initialSteeringAngle);
      at.scale(ratio, ratio);
      at.translate(-img.getWidth() / 2, -img.getHeight() / 2);
      return at;
    }

    public void pintarPersonatge(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(actualImg, at, null);
    }
  }

}
