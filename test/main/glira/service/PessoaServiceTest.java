package main.glira.service;

import main.glira.domain.Pessoa;
import main.glira.domain.Sexo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PessoaServiceTest {
    @Test
    void listaDeMulheresDeveConterApenasMulheres() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", Sexo.FEMININO),
                new Pessoa("Joao", Sexo.MASCULINO),
                new Pessoa("Bia", Sexo.FEMININO)
        );

        PessoaService service = new PessoaService();
        var mulheres = service.filtrarMulheres(pessoas);

        assertTrue(mulheres.stream().allMatch(p -> p.getSexo() == Sexo.FEMININO));
    }
}