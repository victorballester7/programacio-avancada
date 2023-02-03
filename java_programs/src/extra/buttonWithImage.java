package extra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import java.io.*;

public class buttonWithImage implements ActionListener {
  public JButton playButton;
  public Image playButtonImg;
  public int WIDTH;
  public int playButtonImgWidth;

  private void configPlayButton() {
    playButton = new JButton(new ImageIcon(playButtonImg));
    playButton.setMargin(new Insets(0, 0, 0, 0));
    playButton.setBorder(null);
    // playButton.setBorderPainted(false); same as playButton.setBorder(null);
    playButton.setContentAreaFilled(false);
    playButton.setFocusPainted(false);
    playButton.setFocusable(false); // in order to use the keys (not for the button but for the rest of the game).
                                    // Otherwise the keylistener loses focus to the JButton.
    // playButton.setOpaque(false);
    playButton.setBounds((WIDTH - playButtonImgWidth) / 2, 50, playButton.getPreferredSize().width,
        playButton.getPreferredSize().height);
    playButton.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

  }
}
