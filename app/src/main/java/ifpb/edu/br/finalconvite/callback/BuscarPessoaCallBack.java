package ifpb.edu.br.finalconvite.callback;

import java.util.List;

import ifpb.edu.br.finalconvite.entidades.Pessoa;

public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);

}

