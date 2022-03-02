package br.com.agenda.Model;

import java.time.LocalDateTime;

public class Especialidade extends AbstractEntily {

    private String nome;

    public Especialidade() {
    }

    public Especialidade(String nome) {
        this.nome = nome;
    }

    public Especialidade(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome) {
        super(id, cadastro, atualizado, excluido);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Especialidade{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
