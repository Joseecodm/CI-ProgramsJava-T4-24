// Paquetes de la aplicación
import javax.swing.JOptionPane;
import java.util.function.Function;

public class CalculadoraAreaBajoCurva {
    private Function<Double, Double> funcion;

    /*
    * Constructor de la clase CalculadoraAreaBajoCurva.
    *
    * @param funcion Función que se va a utilizar para calcular la area bajo la curva.
    */ 
    public CalculadoraAreaBajoCurva(Function<Double, Double> funcion) {
        this.funcion = funcion;
    }
    /*
    * Metodo utilizado para calcular el area total del area bajo la curva.
    * 
    * @param limiteInferior de la integral.
    * @param limiteSuperior de la integral.
    * 
    * @return total de la integral.
    */
    public double calcularArea(double limiteInferior, double limiteSuperior){
        double areaTotal = 0.0;

        for(double x = limiteInferior; x <= limiteSuperior; x+=0.001){
            double y = funcion.apply(x);
            areaTotal += y * 0.001;
        }

        return areaTotal;
    }
    public static void main(String[] args) throws Exception {
        Function<Double, Double> funcion = x -> 0.005 * x + 0.7; // Define la función de integración
        double limiteInferior = 100; // Determina el limite inferior de la integral 
        double limiteSuperior = 536; // Determina el limite  superior de la integral

        CalculadoraAreaBajoCurva myCalculadora = new CalculadoraAreaBajoCurva(funcion);
        double area = myCalculadora.calcularArea(limiteInferior, limiteSuperior);

        JOptionPane.showMessageDialog(null, "La area bajo la curva es: " + area, "Calculadora de area bajo la curva", JOptionPane.WARNING_MESSAGE);
    }
}