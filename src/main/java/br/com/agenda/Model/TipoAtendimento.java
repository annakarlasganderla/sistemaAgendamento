package br.com.agenda.Model;

public enum TipoAtendimento {

    convenio("Convenio"),
    particular("Particular");

    public final String valor;

    private TipoAtendimento(String valor){
        this.valor = valor;
    }

}
