package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Stage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StageRepository {
    private static ArrayList<Stage> stages = new ArrayList<>(Arrays.asList(
            new Stage("Controle seus gastos!"),
            new Stage("Controle seu tempo!")));

    public List<Stage> getStages() {
        return stages;
    }

}
