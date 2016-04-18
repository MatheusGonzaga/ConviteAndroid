package ifpb.edu.br.finalconvite.asyntask;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.finalconvite.activity.MainActivity;
import ifpb.edu.br.finalconvite.entidades.Administrador;
import ifpb.edu.br.finalconvite.entidades.Pessoa;
import ifpb.edu.br.finalconvite.util.HttpService;
import ifpb.edu.br.finalconvite.util.Response;

public class CadastroAsyncTask extends AsyncTask <Pessoa, Void, Response>{

    private Activity activity;

    public CadastroAsyncTask(Activity activity){

        this.activity = activity;

    }

    @Override
    protected Response doInBackground(Pessoa... params) {

        Response response = null;

        Pessoa pessoa = params[0];

        Gson gson = new Gson();

        try {

            response = HttpService.sendJSONPostResquest("convidado/cadastro", gson.toJson(pessoa));

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

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            Log.e("FinalConvite","OnPostExecute: Erro");
            Toast.makeText(activity, "Algum erro ocorreu", Toast.LENGTH_LONG).show();

        } else {

            Gson gson = new Gson();

            Pessoa pessoa = gson.fromJson(response.getContentValue(), Pessoa.class);

            Toast.makeText(activity,pessoa+" cadastro com sucesso", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();

        }
    }
}
