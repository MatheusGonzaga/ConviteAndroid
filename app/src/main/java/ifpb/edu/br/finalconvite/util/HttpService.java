package ifpb.edu.br.finalconvite.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpService {

    private static final String URL_CONTEXT = "http://ladoss.com.br:8773/Convite_SERVICE/";

    public static Response sendGetRequest(String service, String jsonObject)
            throws MalformedURLException, IOException{

        HttpURLConnection connection = null;
        Response response = null;

        URL url = new URL(URL_CONTEXT + service);
        Log.i("Aqui", "Aqui "+ URL_CONTEXT + service);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("GET");
        connection.connect();
        connection.setRequestProperty("Content-Type", "application/json");

        connection.connect();

        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());

        stream.writeBytes(jsonObject);
        stream.flush();
        stream.close();

        int httpCode = connection.getResponseCode();
        String content = getHttpContent(connection);
        response = new Response(httpCode, content);

        return response;

    }

    public static Response sendJSONPostResquest(String service, String jsonObject)
            throws MalformedURLException, IOException {

        HttpURLConnection connection = null;
        Response response = null;

        URL url = new URL(URL_CONTEXT + service);
        Log.i("Aqui", "Aqui "+ URL_CONTEXT + service);
        Log.i("Aqui:", "Aqui "+jsonObject);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.connect();

        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());

        stream.writeBytes(jsonObject);
        stream.flush();
        stream.close();

        int httpCode = connection.getResponseCode();
        String content = getHttpContent(connection);
        response = new Response(httpCode, content);

        return response;
    }


    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {

            InputStream content = null;

            if(connection.getResponseCode() <= HttpURLConnection.HTTP_BAD_REQUEST)
                content = connection.getInputStream();
            else
                content = connection.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    content, "UTF-8"), 8);

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            content.close();

        } catch (IOException e) {

            Log.e("FinalConvite", "IOException: " + e);

        }

        return builder.toString();
    }

}
