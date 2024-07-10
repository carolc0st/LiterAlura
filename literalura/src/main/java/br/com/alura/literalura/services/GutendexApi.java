package br.com.alura.literalura.services;


import br.com.alura.literalura.models.GutendexResponse;
//import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class GutendexApi {
    String urlBase = "https://gutendex.com/";

    public GutendexResponse RequestApi(String method){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + method))
                .build();
        HttpResponse<String> response = null;
        GutendexResponse gutendexResponse = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ConverterDados converterDados = new ConverterDados();
            gutendexResponse = converterDados.conversorDados(response.body(), GutendexResponse.class);
            return  gutendexResponse;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
