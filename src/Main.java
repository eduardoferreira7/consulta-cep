import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o numero do CEP para consulta: ");
        var cep = leitura.nextLine();

        ConsultaCep consulta = new ConsultaCep();

        try {
            Endereco novoEndereco = consulta.buscaEndereco(cep);
            System.out.println(novoEndereco);

            System.out.println("Você quer gerar um arquivo JSON ?");
            System.out.println("1 - SIM | 2 - NÃO");
            var geraArquivo = leitura.nextLine();

            if(geraArquivo.equalsIgnoreCase("1")){
                GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                geradorDeArquivo.geraJson(novoEndereco);
            }else if(geraArquivo.equalsIgnoreCase("2")){
                System.out.println("Encerrando o programa !");
            } else{
                System.out.println("Opção inválida. Encerrando o programa !");
            }
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação !");
        }



    }
}