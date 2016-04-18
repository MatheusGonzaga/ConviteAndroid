package ifpb.edu.br.finalconvite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.finalconvite.R;
import ifpb.edu.br.finalconvite.adapter.PessoasCustomAdapter;
import ifpb.edu.br.finalconvite.asyntask.BuscarNomeAsyncTask;
import ifpb.edu.br.finalconvite.callback.BuscarPessoaCallBack;
import ifpb.edu.br.finalconvite.entidades.Pessoa;

public class BuscarNomeActivity extends Activity implements TextWatcher, OnItemClickListener, BuscarPessoaCallBack {

    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;
    List<Pessoa> pessoas;
    PessoasCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_nome);


        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        pessoas = new ArrayList<Pessoa>();
        adapter = new PessoasCustomAdapter(this, pessoas);

        nomesListView.setAdapter(adapter);

        nomesListView.setOnItemClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

        String nome = charSequence.toString();

        if (nome.length() >= TAMANHO_MINIMO_TEXTO) {

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);

            BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(this);
            buscarNomeAsyncTask.execute(pessoa);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void backBuscarNome(List<Pessoa> names) {

        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void errorBuscarNome(String error) {

        pessoas.clear();
        adapter.notifyDataSetChanged();

        Toast.makeText(this, error, Toast.LENGTH_LONG);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent it = new Intent(this, PessoaActivity.class);
        it.putExtra("pessoa", pessoas.get(position));
        startActivity(it);

    }
}
