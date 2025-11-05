import java.io.FileWriter;
import java.io.IOException;

public class CadastroCliente {
    public void cadastrar(String nome, int idade) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty() || idade < 18) {
            String msgErro = "Nome não pode ser vazio e idade deve ser maior que 18.";
            logErro(msgErro);
            throw new DadosInvalidosException(msgErro);
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void logErro(String mensagem) {
        try (FileWriter fw = new FileWriter("logerros.txt", true)) {
            fw.write(mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
