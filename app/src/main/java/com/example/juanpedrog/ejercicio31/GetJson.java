package com.example.juanpedrog.ejercicio31;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by juanpedrog on 19/03/18.
 */

public class GetJson extends AsyncTask<Void,Void,Void> {
    String data="";
    String pais="",ciudad="",descripcion="",temperatura="",presion="",humedad="",temp_min="",temp_max="";
    String singleParced="";

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url=new URL("http://api.openweathermap.org/data/2.5/weather?q=Tepic,mx&appid=2f917b6ec566a889645820f48568c003");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=bufferedReader.readLine();
                data+=line;
            }
            JSONObject JO=new JSONObject(data);
            ciudad=""+JO.get("name");
            pais=""+JO.getJSONObject("sys").get("country");
            System.out.println(JO.getJSONArray("weather").length()+"");
            descripcion=""+((JSONObject)JO.getJSONArray("weather").get(0)).get("description");
            temperatura=""+JO.getJSONObject("main").get("temp");
            presion=""+JO.getJSONObject("main").get("pressure");
            humedad=""+JO.getJSONObject("main").get("humidity");
            temp_min=""+JO.getJSONObject("main").get("temp_min");
            temp_max=""+JO.getJSONObject("main").get("temp_max");

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.ciudad.setText(ciudad);
        MainActivity.pais.setText(pais);
        MainActivity.descripcion.setText(descripcion);
        MainActivity.presion.setText(presion);
        MainActivity.humedad.setText(humedad);
        MainActivity.temp_min.setText(temp_min);
        MainActivity.temp_max.setText(temp_max);
        MainActivity.temperatura.setText(temperatura);
    }
}
