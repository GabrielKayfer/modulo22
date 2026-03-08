package main.glira.domain;

import java.util.Objects;

public class Pessoa {


    private final String nome;
    private final Sexo sexo;


    public Pessoa(String nome, Sexo sexo) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome.trim();
        this.sexo = Objects.requireNonNull(sexo, "Sexo não pode ser nulo.");
    }

    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', sexo=" + sexo + "}";
    }
}



