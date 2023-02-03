package extra;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class rotateRectangle {
  public Path2D.Double drawRotatedRectangle(double x0, double y0, double width, double height, double angle) {

    Vector2D[] v = new Vector2D[4];
    Vector2D p = new Vector2D(x0 + width / 2, y0 + height / 2);
    v[0] = new Vector2D(x0, y0);
    v[1] = new Vector2D(x0 + width, y0);
    v[2] = new Vector2D(x0 + width, y0 + height);
    v[3] = new Vector2D(x0, y0 + height);

    for (Vector2D vi : v) {
      vi = vi.rotate(angle, p);
    }

    Path2D.Double path = new Path2D.Double();
    path.moveTo(v[0].x, v[0].y);
    for (int i = 1; i < 4; i++) {
      path.lineTo(v[i].x, v[i].y);
    }
    path.closePath();
    return path;
  }
}
