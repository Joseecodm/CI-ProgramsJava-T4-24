import java.util.function.Function;
import javax.swing.JOptionPane;

public class CalculadoraVolumenSolidosRevolucion {

    private Function<Double, Double> funcion;

    public CalculadoraVolumenSolidosRevolucion(Function<Double, Double> _funcion){

        funcion = _funcion;
    }

    public double calcularVolumen(double limiteInferior, double limiteSuperior){

        double volumenTotal = 0.0;
        double incremento = 0.001;
        for(double x = limiteInferior; x <= limiteSuperior; x += incremento){

            double radio = funcion.apply(x);
            double areaDisco = Math.PI * Math.pow(radio, 2);
            volumenTotal += areaDisco * incremento;
        }

        return volumenTotal;
    }

    public static void main(String[] args) throws Exception {

        Function<Double, Double> funcion = x -> x + 2; 
        double limiteInferior = -2.0;
        double limiteSuperior = 2.0;

        CalculadoraVolumenSolidosRevolucion myCalculadora = new CalculadoraVolumenSolidosRevolucion(funcion);
        double volumen = myCalculadora.calcularVolumen(limiteInferior, limiteSuperior);

        JOptionPane.showMessageDialog(null, "El volumen es: " + volumen, null, 0);
    }
}
