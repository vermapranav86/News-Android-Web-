/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKGJava;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Api_Call {

    public static ArrayList<NewsData> apicall(String url1)  {
        
        String apiresult = "";
        ArrayList<NewsData> data = new ArrayList<NewsData>();
        JSONArray jsonarray = new JSONArray();
        try {
        
        
        URL url = new URL(url1);

        
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url.toString())).build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> responce = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiresult= responce.body();
          
            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject jsonresult = (JSONObject) parse.parse(apiresult);
             
            //Get the required object from the above created object
            jsonarray = (JSONArray) jsonresult.get("articles");
            for(int i=0;i<jsonarray.size();i++)
            {
                JSONObject item = (JSONObject)jsonarray.get(i);
                NewsData obj = new NewsData((String)item.get("urlToImage"),(String)item.get("title"),(String)item.get("author"),(String)item.get("url"),(String)item.get("publishedAt"));
                data.add(obj);
                
            }      
           
        } catch (IOException | InterruptedException  ex) {
            Logger.getLogger(Api_Call.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Api_Call.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

}
