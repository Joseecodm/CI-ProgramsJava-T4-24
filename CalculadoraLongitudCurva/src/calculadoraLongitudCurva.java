import java.util.function.Function;
import javax.swing.JOptionPane;

public class calculadoraLongitudCurva {

    private Function<Double, Double> funcion;

    public calculadoraLongitudCurva(Function<Double, Double> _funcion) {
        funcion = _funcion;
    } 

    public double calcularLongitud(double limInferior, double limSuperior){
        double longitudTotal = 0.0;
        double incremento = 0.001;

        for (double x = limInferior; x <= limSuperior; x += incremento) {
            double y = funcion.apply(x);
            double y_a = funcion.apply(x + incremento);

            longitudTotal += Math.sqrt(Math.pow(incremento, 2) + Math.pow(y_a - y, 2));
        }
        return longitudTotal;
    }

    public static void main(String[] args) throws Exception {
        
        Function<Double, Double> funcion = x -> (9 * Math.pow(x, 4) + 4) / (12 * Math.pow(x, 2));
        double limInferior = 1; 
        double limSuperior = 2;

        calculadoraLongitudCurva myCalculadora = new calculadoraLongitudCurva(funcion);
        double longitud = myCalculadora.calcularLongitud(limInferior, limSuperior);

        JOptionPane.showMessageDialog(null, longitud, null, 0);
    }
}