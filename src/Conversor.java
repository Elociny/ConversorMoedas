import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Dados converterMoeda(String base_code, String target_code, double qtdConverter) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/f676e3233a5fb60b58a20dee/pair/" + base_code + "/" + target_code + "/" + qtdConverter);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui converter");
        }

        return new Gson().fromJson(response.body(), Dados.class);
    }
}
