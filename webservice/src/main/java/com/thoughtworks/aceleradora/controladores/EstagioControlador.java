package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.servicos.EstagioServico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estagio")
public class EstagioControlador {

    private EstagioServico estagioServico;

    public EstagioControlador(EstagioServico estagioServico) {
        this.estagioServico = estagioServico;
    }
}
