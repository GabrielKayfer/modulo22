package br.com.glira.service;

import br.com.glira.domain.Pessoa;
import br.com.glira.domain.Sexo;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {

    public List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(p -> p.getSexo() == Sexo.FEMININO)
                .collect(Collectors.toList());
    }
}
