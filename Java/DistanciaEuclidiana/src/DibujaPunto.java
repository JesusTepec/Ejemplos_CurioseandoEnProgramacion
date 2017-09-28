import javax.swing.*;
import java.awt.*;

/**
 * Created by Jesus on 25/07/2017.
 */
public class DibujaPunto extends JPanel {

    private Punto punto;

    public void agregarPunto(Punto punto){
        this.punto = punto;
        repaint();
    }

    private void dibujar(Graphics g) {
        int x = (int)punto.obtenerX();
        int y = (int)punto.obtenerY();
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);

        g.fillOval (x, y, 5, 5);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);
    }

}
