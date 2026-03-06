package br.com.glira.app;

import br.com.glira.domain.Pessoa;
import br.com.glira.io.ConsolePessoaReader;
import br.com.glira.service.PessoaService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConsolePessoaReader reader = new ConsolePessoaReader(scanner, "fechar" + ".");

        PessoaService service = new PessoaService();

        List<Pessoa> pessoas = reader.lerPessoas();
        List<Pessoa> mulheres = service.filtrarMulheres(pessoas);

        System.out.println("\nMulheres cadastradas:");
        mulheres.forEach(m -> System.out.println(m.getNome()));

        scanner.close();
    }
}