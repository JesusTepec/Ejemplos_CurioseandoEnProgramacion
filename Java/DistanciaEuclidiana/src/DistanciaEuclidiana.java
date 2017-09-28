import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Jesus on 25/07/2017.
 */
public class DistanciaEuclidiana extends JFrame{
    private final DibujaPunto lienzo;

    public DistanciaEuclidiana(){
        lienzo = new DibujaPunto();
        add(lienzo);

        setTitle("Puntos");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void agregarPunto(Punto punto){
        lienzo.agregarPunto(punto);
    }

    public static void main(String []args){
        DistanciaEuclidiana principal = new DistanciaEuclidiana();
        Punto p1 = new Punto(50, 100);
        principal.agregarPunto(p1);
        Punto p2 = new Punto(30, 7);
        principal.agregarPunto(p2);

        try {
            System.out.println("Distancia p1 a p2: " + p1.distancia(p2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                principal.setVisible(true);
            }
        });
    }
}
