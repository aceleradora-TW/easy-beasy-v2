package com.thoughtworks.aceleradora.controladores;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.servicos.PerguntaServico;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ws/testeum")
public class PerguntaControlador {
    private PerguntaServico perguntaServico;

    public PerguntaControlador(PerguntaServico perguntaServico) {
        this.perguntaServico = perguntaServico;
    }

    @GetMapping(path = "/")
    public List<Pergunta> pegaListaDePerguntas() {
        return perguntaServico.pegarMinhasPerguntas();
    }

    @PostMapping(path = "/")
    public void adicionaPergunta(@RequestBody Pergunta pergunta) {
        perguntaServico.adicionaPergunta(pergunta);
    }

    @GetMapping(path = "/{indice}")
    public Pergunta pegaPergunta(@PathVariable("indice") int indice) {
        return perguntaServico.pegaPergunta(indice);
    }

    @DeleteMapping(path = "/{indice}")
    public Pergunta removePergunta(@PathVariable("indice") int indice) {
        return perguntaServico.removePergunta(indice);
    }
}
