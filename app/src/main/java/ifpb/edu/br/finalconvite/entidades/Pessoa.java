package ifpb.edu.br.finalconvite.entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pessoa implements Serializable {

    public Pessoa (){}

    public Pessoa (int id, String nome, String email, String endereco, String cpf){

        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;

    }

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("endereco")
    private String endereco;

    @SerializedName("cpf")
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "[id: " + id + "; nome: " + nome + "; email: " + email + "; endereco: " + endereco + "; cpf: " + cpf + "]";

    }
}
