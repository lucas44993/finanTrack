package com.finanTrack.Tembo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Component
public class Tembo {

    @Value("${external.api.url}")
    private String apiUrl;

    @Value("${external.api.token}")
    private String token;

    @Value("${external.api.orgId}")
    private String orgId;

    @Value("${external.api.instanceId}")
    private String instanceId;


    @PostConstruct
    public void init() {
        iniciarBancoDeDados(); // Chama o método após a injeção
    }

    public void iniciarBancoDeDados() {

        // Parâmetros da query
        String eventType = "start";

        // Criar URL com parâmetros de query
        String url = String.format("%s/org_%s/instances/%s?event_type=%s", apiUrl, orgId, instanceId, eventType);

        // Verifique se a URL está bem formada
        try {
            // Criar URL e conexão
            URL obj = new URL(url); // Isso pode lançar MalformedURLException
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configurar método de requisição
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + token);
            con.setRequestProperty("Content-Type", "application/json");

            // Habilitar envio de dados
            con.setDoOutput(true);

            // Enviar requisição sem corpo
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                // Para um POST sem corpo, não é necessário enviar dados
                wr.flush();
            }

            // Ler resposta
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Processar a resposta
            String jsonResponse = response.toString();
            System.out.println("Response: ok ");

        } catch (MalformedURLException e) {
            System.out.println("URL malformada: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}