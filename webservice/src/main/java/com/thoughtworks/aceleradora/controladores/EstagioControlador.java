package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Estagio;
import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.servicos.EstagioServico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estagio")
public class EstagioControlador {

    private EstagioServico estagioServico;

    public EstagioControlador(EstagioServico estagioServico) {
        this.estagioServico = estagioServico;
    }

    @GetMapping(path = "/solucao")
    public List<Estagio> pegaListaDeSolucao() {
        return estagioServico.pegarSolucoes();
    }

    @GetMapping(path = "/{indice}")
    public Estagio pegaSolucao(@PathVariable("indice") int indice) {
        return estagioServico.pegaSolucao(indice);
    }

}
