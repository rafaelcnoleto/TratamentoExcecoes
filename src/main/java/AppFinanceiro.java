import java.io.FileWriter;
import java.io.IOException;

public class AppFinanceiro {

    static double calcularDivisao(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida.");
            }
            return a / b;
        } catch (ArithmeticException e) {
            String erro = "Erro: " + e.getMessage();
            System.out.println(erro);
            registrarErro(erro);
            return 0;
        } finally {
            System.out.println("Operação finalizada com sucesso.");
        }
    }

    static void registrarErro(String mensagem) {
        try (FileWriter fw = new FileWriter("log_erros.txt", true)) {
            fw.write(mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Falha ao registrar o erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Testando cálculo
        System.out.println("Teste 1: Divisão normal");
        double resultado = calcularDivisao(10, 2);
        System.out.println("Resultado: " + resultado + "\n");

        System.out.println("Teste 2: Divisão por zero");
        calcularDivisao(10, 0);
        System.out.println();

        // Testando cadastro
        CadastroCliente cadastro = new CadastroCliente();

        try {
            System.out.println("Tentando cadastrar cliente...");
            cadastro.cadastrar("", 16);
        } catch (DadosInvalidosException e) {
            String erro = "Erro: " + e.getMessage();
            System.out.println(erro);
            CadastroCliente.registrarErro(erro);
        }

        System.out.println("\nLogs salvos no arquivo txt.");
    }
}
