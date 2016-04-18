package ifpb.edu.br.finalconvite.entidades;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Administrador implements Serializable{

    public Administrador (){}

    public Administrador (String senha, String email){

        this.email = email;
        this.senha = senha;

    }

    @SerializedName("senha")
    private String senha;

    @SerializedName("email")
    private String email;

    @SerializedName("nome")
    private String nome;

    @SerializedName("id")
    private Integer id;

    public String getSenha() {
        return senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {

        return "{email: " + email + "; senha: " + senha + "}";

    }
}
