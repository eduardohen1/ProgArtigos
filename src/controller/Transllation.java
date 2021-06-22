/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.google.gson.Gson;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.text.html.parser.Entity;
import org.json.JSONArray;
import org.json.JSONObject;
import model.HTMLEntities;
import model.RequestTranslate;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.*;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author MGF
 */
public class Transllation {
    
    private static HttpURLConnection connection;
    
    public static String traduzir(String texto)throws IOException, InterruptedException{
        String resposta = texto;
        try{
            //URL url = new URL("https://www.googleapis.com/language/translate/v2?key=AIzaSyDXlJpemuqjkWhBx6rVjyv4jhMOmMF4MAk");            
            RequestTranslate requestJson = new RequestTranslate();
            requestJson.q = texto;
            requestJson.target = "pt";
            
            String postUrl = "https://www.googleapis.com/language/translate/v2?key=AIzaSyDXlJpemuqjkWhBx6rVjyv4jhMOmMF4MAk";
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(requestJson));
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            resposta = getJSONResponse(new JSONObject(EntityUtils.toString(response.getEntity())));
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(null, "Erro ao traduzir texto: " + ex.getMessage(), "Erro ao gravar dados no banco de dados.", JOptionPane.WARNING_MESSAGE);
        }
        return resposta;
    }
    
    private static String getJSONResponse(final JSONObject json) throws Exception{
        final JSONObject data = json.getJSONObject("data");
        final JSONArray translations = data.getJSONArray("translations");
        final JSONObject translation = translations.getJSONObject(0);
        final String translatedText = translation.getString("translatedText");

        return HTMLEntities.unhtmlentities(translatedText);
    }
    
}
