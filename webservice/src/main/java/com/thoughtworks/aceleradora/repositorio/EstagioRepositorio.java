package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Estagio;
import com.thoughtworks.aceleradora.dominio.Pergunta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EstagioRepositorio {
    private static ArrayList<Estagio> estagios = new ArrayList<>(Arrays.asList(
            new Estagio("Controle seus gastos!"),
            new Estagio("Controle seu tempo!")));

    public List<Estagio> pegaSolucoesEstagio() {
        return estagios;
    }

}
