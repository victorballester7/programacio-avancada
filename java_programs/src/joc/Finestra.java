package java_programs.src.joc;

import java.awt.*;

public class Finestra extends Frame {
  Joc j;
  Image im;
  Graphics g;
  int ALÇADA = 800, AMPLADA = 800;

  public static void main(String[] args) {
    new Finestra();
  }

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
