import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {

  private static final int WIDTH = 10;
  private static final int HEIGHT = 60;

  int x;
  int y = 0;
  int ya = 0;
  private Game game;
  private int player;

  public Paddle(int player, Game game) {
    this.game = game;
    this.player = player;
    if (player == 1) {
      x = 0;
    } else {
      x = 572;
    }
  }

  public void move() {
    if (y + ya > 0 && y + ya < game.getHeight() - HEIGHT) {
      y = y + ya;
    }
  }

  public void paint(Graphics2D g) {
    g.fillRect(x, y, WIDTH, HEIGHT);
  }

  public Rectangle getBounds() {
    return new Rectangle(x, y, WIDTH, HEIGHT);
  }

  public void keyReleased(KeyEvent e) {
    ya = 0;
  }

  public void keyPressed(KeyEvent e) {
    if (player == 1) {
      if (e.getKeyCode() == KeyEvent.VK_W) {
        ya = -game.speed;
      } else if (e.getKeyCode() == KeyEvent.VK_S) {
        ya = game.speed;
      }
    } else {
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        ya = -game.speed;
      } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        ya = game.speed;
      }
    }
  }
}
