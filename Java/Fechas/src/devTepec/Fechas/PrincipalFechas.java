package devTepec.Fechas;

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrincipalFechas {

    public static void main(String [] args){

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        String inputAnio = JOptionPane.showInputDialog(null, "Ingresa el año que quieres consultar: ");
        String fecha = JOptionPane.showInputDialog(null, "Ingresa la fecha de tu cumpleaños en formato dias/mes ( 06/10 )");

        int numeroAnios = Integer.parseInt(inputAnio) - anioActual;
        String datosFecha[] = fecha.split("/");
        int mes = Integer.parseInt(datosFecha[0]);
        int dia = Integer.parseInt(datosFecha[1]);

        GregorianCalendar gregorianCalendar = new GregorianCalendar(anioActual, mes, dia);

        for (int i = 0; i < numeroAnios; i++){
            gregorianCalendar.roll(Calendar.YEAR, 1);
        }
        String dayName = gregorianCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        JOptionPane.showMessageDialog(null, "Tu proximo cumpleaños será en \"" + dayName+"\"");
    }
}
