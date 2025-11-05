import java.io.FileWriter;
import java.io.IOException;

public class AppFinanceiro {

    public static double calcularDivisao(double a, double b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return 0;
        } finally {
            System.out.println("Operação finalizada com sucesso.");
        }
    }

    private static void logErro(String mensagem) {
        try (FileWriter fw = new FileWriter("logerros.txt", true)) {
            fw.write(mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
