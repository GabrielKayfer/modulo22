package main.glira.domain;

public enum Sexo {

    FEMININO,
    MASCULINO;

    public static Sexo from(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Sexo não pode ser nulo.");
        }

        String valor = texto.trim().toUpperCase();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("Sexo não pode ser vazio.");
        }

        if (valor.equals("F") || valor.equals("FEMININO")) {
            return FEMININO;
        }
        if (valor.equals("M") || valor.equals("MASCULINO")) {
            return MASCULINO;
        }

        throw new IllegalArgumentException("Sexo inválido: " + texto + ". Use F/M ou Feminino/Masculino.");
    }
}
