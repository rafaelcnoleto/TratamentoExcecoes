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
        System.out.println("Erro: " + e.getMessage());
    }
}