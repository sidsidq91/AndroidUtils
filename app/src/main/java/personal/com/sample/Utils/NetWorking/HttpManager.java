package personal.com.sample.Utils.NetWorking;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {

    public static String getData(String uri){
        BufferedReader reader = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line + "\n");
            }
            return sb.toString();
        }catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    //request with basic authorization
    public static String getData(String uri, String userName, String passWord){
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        byte[] loginBytes = (userName + ":" + passWord).getBytes();
        StringBuilder loginbBuilder = new StringBuilder()
                .append("Basic ")
                .append(Base64.encodeToString(loginBytes, Base64.DEFAULT));
        try {
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("Authorization", loginbBuilder.toString());

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            int status;
            try {
                status = connection.getResponseCode();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
