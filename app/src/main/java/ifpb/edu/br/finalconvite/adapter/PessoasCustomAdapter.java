package ifpb.edu.br.finalconvite.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ifpb.edu.br.finalconvite.R;
import ifpb.edu.br.finalconvite.entidades.Pessoa;

public class PessoasCustomAdapter extends BaseAdapter{

    Context context;

    List<Pessoa> pessoas;

    public PessoasCustomAdapter(Context context, List<Pessoa> pessoas){

        this.pessoas = pessoas;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)  context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.textCpf = (TextView) convertView.findViewById(R.id.cpf);
            holder.txtNome = (TextView) convertView.findViewById(R.id.nome);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.email);
            holder.txtId = (TextView) convertView.findViewById(R.id.id);
            holder.txtEndereco = (TextView) convertView.findViewById(R.id.endereco);

            convertView.setTag(holder);

        }else {

            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoaItem = (Pessoa) getItem(position);

        holder.txtNome.setText("Nome: " + pessoaItem.getNome());
        holder.textCpf.setText("Descrição: " + pessoaItem.getCpf());
        holder.txtEmail.setText("Email: " + pessoaItem.getEmail());
        holder.txtId.setText("ID: " + pessoaItem.getId());
        holder.txtEndereco.setText("Endereco: " + pessoaItem.getEndereco());


        return convertView;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {

        TextView txtNome;
        TextView textCpf;
        TextView txtId;
        TextView txtEmail;
        TextView txtEndereco;

    }

}
