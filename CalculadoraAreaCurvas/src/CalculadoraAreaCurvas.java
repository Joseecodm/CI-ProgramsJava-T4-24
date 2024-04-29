import javax.swing.JOptionPane;
import java.util.function.Function;

public class CalculadoraAreaCurvas {
    private Function<Double, Double> funcionF;
    private Function<Double, Double> funcionG;

    public CalculadoraAreaCurvas(Function<Double, Double> _funcionF, Function<Double, Double> _funcionG) {
        funcionF = _funcionF;
        funcionG = _funcionG;
    }
    
    public double calcularArea(double limInferior, double limSuperior) {
        double areaTotal = 0.0;

        for (double x = limInferior; x <= limSuperior; x += 0.001) {
            double yF = funcionF.apply(x);
            double yG = funcionG.apply(x);
            double altura = Math.abs(yF - yG);
            areaTotal += altura  * 0.001;
        }

        return areaTotal;
    }
    public static void main(String[] args) throws Exception {
        
        Function<Double, Double> funcionF = x -> 1 + 2 * x - x * x;
        Function<Double, Double> funcionG = x -> x - 1;

        double limInferior = -1;
        double limSuperior = 2;

        CalculadoraAreaCurvas myCalculadora = new CalculadoraAreaCurvas(funcionF, funcionG);
        double areaTotal = myCalculadora.calcularArea(limInferior, limSuperior);

        JOptionPane.showMessageDialog(null, "La area total es: " + areaTotal);
    }
}
