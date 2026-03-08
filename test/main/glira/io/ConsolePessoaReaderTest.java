package main.glira.io;

import main.glira.domain.Sexo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePessoaReaderTest {

    @Test
    void deveIgnorarSexoInvalidoEContinuarLendo() {
        String entrada = String.join("\n",
                "Ana,X",
                "Bia,F",
                "fechar"
        ) + "\n";

        ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(in);

        ConsolePessoaReader reader = new ConsolePessoaReader(scanner, "fechar");

        // Act
        var pessoas = reader.lerPessoas();

        // Assert: só a válida entrou
        assertEquals(1, pessoas.size());
        assertEquals("Bia", pessoas.get(0).getNome());
        assertEquals(Sexo.FEMININO, pessoas.get(0).getSexo());
    }

    @Test
    void deveIgnorarEntradaSemVirgulaEContinuar() {
        String entrada = String.join("\n",
                "AnaF",      // inválida (sem vírgula)
                "Ana,F",     // válida
                "fechar"
        ) + "\n";

        ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(in);

        ConsolePessoaReader reader = new ConsolePessoaReader(scanner, "fechar");

        var pessoas = reader.lerPessoas();

        assertEquals(1, pessoas.size());
        assertEquals("Ana", pessoas.get(0).getNome());
        assertEquals(Sexo.FEMININO, pessoas.get(0).getSexo());
    }
}