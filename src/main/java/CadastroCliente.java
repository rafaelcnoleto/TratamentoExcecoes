import java.io.FileWriter;
import java.io.IOException;

class CadastroCliente {

    void cadastrar(String nome, int idade) throws DadosInvalidosException {
        if (nome == null || nome.isEmpty() || idade < 18) {
            throw new DadosInvalidosException("Nome não pode ser vazio e idade deve ser maior que 18.");
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void registrarErro(String mensagem) {
        try (FileWriter fw = new FileWriter("log_erros.txt", true)) {
            fw.write(mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Falha ao registrar o erro: " + e.getMessage());
        }
    }
}
