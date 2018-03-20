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
    String dataParsed="";
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
            dataParsed="País: "+JO.getJSONObject("sys").get("country")+"\nCiudad: "+JO.getJSONObject("sys").get("name");

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.dataParsed);
    }
}
