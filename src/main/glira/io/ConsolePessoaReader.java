package main.glira.io;

import main.glira.domain.Pessoa;
import main.glira.domain.Sexo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePessoaReader {

    private final Scanner scanner;
    private final String comandoParada;

    public ConsolePessoaReader(Scanner scanner, String comandoParada) {
        this.scanner = scanner;
        this.comandoParada = comandoParada;
    }

    public List<Pessoa> lerPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite no formato nome,sexo (ex: Ana,F).");
        System.out.println("Para encerrar, digite: " + comandoParada);

        while (true) {
            String linha = scanner.nextLine().trim();

            if (linha.equalsIgnoreCase(comandoParada)) {
                break;
            }

            String[] partes = linha.split(",");
            if (partes.length != 2) {
                System.out.println("Entrada inválida. Use nome,sexo (ex: Ana,F).");
                continue;
            }

            String nome = partes[0].trim();
            String sexoTexto = partes[1].trim();

            try {
                Sexo sexo = Sexo.from(sexoTexto);
                pessoas.add(new Pessoa(nome, sexo));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return pessoas;
    }
}