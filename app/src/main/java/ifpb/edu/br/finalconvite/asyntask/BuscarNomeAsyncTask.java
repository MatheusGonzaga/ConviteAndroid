package ifpb.edu.br.finalconvite.asyntask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.finalconvite.callback.BuscarPessoaCallBack;
import ifpb.edu.br.finalconvite.entidades.Pessoa;
import ifpb.edu.br.finalconvite.util.HttpService;
import ifpb.edu.br.finalconvite.util.Response;

public class BuscarNomeAsyncTask extends AsyncTask<Pessoa, Void, Response> {

    private BuscarPessoaCallBack buscarNomeCallBack;

    public BuscarNomeAsyncTask(BuscarPessoaCallBack buscarNomeCallBack) {

        this.buscarNomeCallBack = buscarNomeCallBack;
    }

    @Override
    protected Response doInBackground(Pessoa... pessoas) {

        Response response = null;

        Pessoa pessoa = pessoas[0];

        try {

            Gson gson = new Gson();

            response = HttpService.sendGetRequest("convidado/pesquisar/nome/Jose", gson.toJson(pessoa));

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
        Log.i("EditTextListener"," Conteúdo: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            buscarNomeCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Pessoa> pessoas = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Pessoa>>(){}.getType());

            buscarNomeCallBack.backBuscarNome(pessoas);
        }
    }
}
