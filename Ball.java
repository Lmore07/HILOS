import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0) {
            game.rightScore++;
            xa = game.speed;
        } else if (x + xa > 579 - DIAMETER) {
            game.leftScore++;
            xa = -game.speed;
        } else if (y + ya < 0 || y + ya > game.getHeight() - DIAMETER) {
            ya = -ya;
        } else if (collision()) {
            xa = -xa;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.leftPaddle.getBounds().intersects(getBounds()) || game.rightPaddle.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}