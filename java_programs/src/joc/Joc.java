package joc;

import java.awt.Color;

public class Joc {
  Finestra f;
  Cotxe c[] = new Cotxe[3];
  // int y;

  public Joc(Finestra f) {
    this.f = f;
  }

  public void run() {
    // inicialització dels objectes del joc
    // y = 50;
    c[0] = new Cotxe(50, 50, 1);
    c[1] = new Cotxe(50, 150, 3);
    c[2] = new Cotxe(50, 250, 5);
    while (true) {
      moureElement();// moure els objectes de pantalla
      // detectar col·lisió
      repintarPantalla();// repintar la pantalla
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void moureElement() {
    // y++;
    // for(int i=0;i<c.length;i++)
    // c[i].moure(1);
    // alternativa a sota:
    for (Cotxe cotxe : c) {
      cotxe.moure(1);
    }
  }

  private void repintarPantalla() {
    f.g.setColor(Color.WHITE);
    f.g.fillRect(0, 0, f.ALÇADA, f.AMPLADA);
    // f.g.setColor(Color.RED);
    // f.g.drawLine(50, 50, 700, y);
    for (Cotxe cotxe : c) {
      cotxe.pintar(f.g);
    }
    f.repaint();
  }
}
