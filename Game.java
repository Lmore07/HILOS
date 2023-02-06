import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {

  private static final long serialVersionUID = 1L;

  Ball ball = new Ball(this);
  Paddle leftPaddle = new Paddle(1, this);
  Paddle rightPaddle = new Paddle(2, this);
  public int speed = 4;
  public int leftScore = 0;
  public int rightScore = 0;

  public Game() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
        leftPaddle.keyReleased(e);
        rightPaddle.keyReleased(e);
      }

      @Override
      public void keyPressed(KeyEvent e) {
        leftPaddle.keyPressed(e);
        rightPaddle.keyPressed(e);
      }
    });
    setFocusable(true);
  }

  private void move() {
    ball.move();
    leftPaddle.move();
    rightPaddle.move();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    ball.paint(g2d);
    leftPaddle.paint(g2d);
    rightPaddle.paint(g2d);

    g2d.drawString(String.valueOf(leftScore), 15, 20);
    g2d.drawString(String.valueOf(rightScore), 565, 20);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Mini Tennis");
    Game game = new Game();
    frame.add(game);
    frame.setSize(600, 600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) {
      game.move();
      game.repaint();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
