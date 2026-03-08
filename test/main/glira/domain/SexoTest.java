package main.glira.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SexoTest {

    @Test
    void deveConverterVariacoesDeFeminino() {
        assertEquals(Sexo.FEMININO, Sexo.from("F"));
        assertEquals(Sexo.FEMININO, Sexo.from("f"));
        assertEquals(Sexo.FEMININO, Sexo.from(" Feminino "));
        assertEquals(Sexo.FEMININO, Sexo.from("FEMININO"));
    }

    @Test
    void deveConverterVariacoesDeMasculino() {
        assertEquals(Sexo.MASCULINO, Sexo.from("M"));
        assertEquals(Sexo.MASCULINO, Sexo.from("m"));
        assertEquals(Sexo.MASCULINO, Sexo.from(" Masculino "));
        assertEquals(Sexo.MASCULINO, Sexo.from("MASCULINO"));
    }

    @Test
    void deveLancarExcecaoParaSexoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Sexo.from("X"));
        assertThrows(IllegalArgumentException.class, () -> Sexo.from(""));
        assertThrows(IllegalArgumentException.class, () -> Sexo.from("   "));
        assertThrows(IllegalArgumentException.class, () -> Sexo.from(null));
    }
}