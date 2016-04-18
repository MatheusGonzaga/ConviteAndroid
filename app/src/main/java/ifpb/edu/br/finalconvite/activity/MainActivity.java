package ifpb.edu.br.finalconvite.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ifpb.edu.br.finalconvite.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonCadastro;
    private Button buttonBuscarNome;
    private Button buttonBuscarQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastro = (Button) findViewById(R.id.buttonCadastro);

        buttonBuscarNome = (Button) findViewById(R.id.buttonBuscarNome);

        buttonBuscarQR = (Button) findViewById(R.id.buttonBuscarQR);

        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cadastroIntent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(cadastroIntent);

            }
        });

        buttonBuscarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent buscarNomeIntent = new Intent(MainActivity.this, BuscarNomeActivity.class);
                startActivity(buscarNomeIntent);

            }
        });

        buttonBuscarQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent buscarQRIntent = new Intent(MainActivity.this, BuscarQRActivity.class);
                startActivity(buscarQRIntent);

            }
        });
    }
}
