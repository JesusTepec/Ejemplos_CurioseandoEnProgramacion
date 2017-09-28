/**
 * Created by Jesus on 25/07/2017.
 */
public class Punto {

    private double x, y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto(){
        this(0, 0);
    }

    public double obtenerX(){
        return x;
    }

    public double obtenerY(){
        return y;
    }

    public double distancia(Punto p) throws Exception{
        if (p == null)
            throw new Exception("Ups! Debe inicializar el objeto punto");

        double diferenciaX = x - p.obtenerX();
        double diferenciaY = y - p.obtenerY();

        return Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
    }
}