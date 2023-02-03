package joc;

import java.awt.Color;

import java.awt.Graphics;

public class Cotxe {
  int x, y, v;
  int ample = 50, alt = 30;

  public Cotxe(int x, int y, int v) {
    this.x = x;
    this.y = y;
    this.v = v;
  }

  void moure(double dt) {
    x += dt * v;
  }

  void pintar(Graphics g) {
    g.setColor(Color.BLACK);
    g.drawRect(x, y, ample, alt);
    g.drawLine(x + ample * 3 / 4, y, x + ample * 3 / 4, y + alt);
  }
}
