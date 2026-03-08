package main.glira.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void deveCriarPessoaValidaEAplicarTrimNoNome() {
        String nomeComEspaco = "  Ana  ";

        Pessoa pessoa = new Pessoa(nomeComEspaco, Sexo.FEMININO);


        assertEquals("Ana", pessoa.getNome());
        assertEquals(Sexo.FEMININO, pessoa.getSexo());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNuloOuVazio() {
        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> new Pessoa(null, Sexo.FEMININO));
        assertThrows(IllegalArgumentException.class, () -> new Pessoa("", Sexo.FEMININO));
        assertThrows(IllegalArgumentException.class, () -> new Pessoa("   ", Sexo.FEMININO));
    }

    @Test
    void deveLancarExcecaoQuandoSexoForNulo() {
        assertThrows(NullPointerException.class, () -> new Pessoa("Ana", null));
    }
}