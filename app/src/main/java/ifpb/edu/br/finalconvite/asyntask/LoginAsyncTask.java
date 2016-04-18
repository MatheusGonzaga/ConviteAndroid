
package ifpb.edu.br.finalconvite.asyntask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.finalconvite.activity.MainActivity;
import ifpb.edu.br.finalconvite.entidades.Administrador;
import ifpb.edu.br.finalconvite.util.HttpService;
import ifpb.edu.br.finalconvite.util.Response;

public class LoginAsyncTask extends AsyncTask<Administrador, Void, Response> {

    private Activity activity;

    public LoginAsyncTask(Activity activity){

        this.activity = activity;

    }

    @Override
    protected Response doInBackground(Administrador... administradors) {

        Response response = null;

        Administrador administrador = administradors[0];

        Log.i("FinalConvite", "doInBack"+administradors[0]);

        Gson gson = new Gson();

        try {

            response = HttpService.sendJSONPostResquest("usuario/login", gson.toJson(administrador));

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;

    }

    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp == HttpURLConnection.HTTP_OK) {

            Gson gson = new Gson();

            Administrador administrador = gson.fromJson(response.getContentValue(), Administrador.class);

            Toast.makeText(activity,administrador+" está logado no sistema", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();

        } else {

            Log.e("FinalConvite","OnPostExecute: Erro");
            Toast.makeText(activity,"Usuario ou Senha incorreta", Toast.LENGTH_LONG).show();

        }
    }
}
