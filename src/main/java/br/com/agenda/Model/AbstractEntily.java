package br.com.agenda.Model;

import java.time.LocalDateTime;

public abstract class AbstractEntily {

    private Long id;
    private LocalDateTime cadastro;
    private LocalDateTime atualizado;
    private LocalDateTime excluido;

    public AbstractEntily() {
    }

    public AbstractEntily(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido) {
        this.id = id;
        this.cadastro = cadastro;
        this.atualizado = atualizado;
        this.excluido = excluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
        this.cadastro = cadastro;
    }

    public LocalDateTime getAtualizadp() {
        return atualizado;
    }

    public void setAtualizado(LocalDateTime atualizadp) {
        this.atualizado = atualizado;
    }

    public LocalDateTime getExcluido() {
        return excluido;
    }

    public void setExcluido(LocalDateTime excluido) {
        this.excluido = excluido;
    }

    @Override
    public String toString() {
        return "AbstractEntily{" +
                "id=" + id +
                ", cadastro=" + cadastro +
                ", atualizadp=" + atualizado +
                ", excluido=" + excluido +
                '}';
    }

}
