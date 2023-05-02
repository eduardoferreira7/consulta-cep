import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

public class GeradorDeArquivo {

    public void geraJson(Endereco endereco){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try{
            FileWriter escrita = new FileWriter(endereco.cep() + ".json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
            System.out.println("Arquivo criado com sucesso !");
        }catch (Exception e){
            System.out.println("Não foi possível gerar o arquivo json");
        }
    }

}
