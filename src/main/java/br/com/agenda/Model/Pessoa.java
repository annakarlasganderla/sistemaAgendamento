package br.com.agenda.Model;

import java.time.LocalDateTime;

public abstract class Pessoa extends AbstractEntily {

    private String nome;
    private String cpf;
    private String rg;
    private String cep;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private String nacionalidade;
    private Sexo sexo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
    }

    public Pessoa(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo) {
        super(id, cadastro, atualizado, excluido);
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.nacionalidade = nacionalidade;
        this.sexo = sexo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
