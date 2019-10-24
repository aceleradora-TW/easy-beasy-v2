package com.thoughtworks.aceleradora.repositorio;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.repositorio.PerguntaRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PerguntaRepositoryTest {

    @Test
    public void retornaOkSeEuSalvarUmaPerguntaValida() {
        // Insumos
        Pergunta pergunta = new Pergunta(1, "Você controla seus testes?");
        // ação
        PerguntaRepository perguntaRepository = new PerguntaRepository();
        List<Pergunta> resultado = perguntaRepository.salvar(pergunta);

        // validação
        Pergunta perguntaResultado = resultado.get(0);
        Assert.assertEquals(pergunta.getOrdem(), perguntaResultado.getOrdem());
        Assert.assertEquals(pergunta.getDescricao(), perguntaResultado.getDescricao());
    }

    @Test
    public void retornaErroSeEuSalvarUmaPerguntaSemDescricao() {
        Pergunta pergunta = new Pergunta(1, null);

        PerguntaRepository perguntaRepository = new PerguntaRepository();
        List<Pergunta> resultado = perguntaRepository.salvar(pergunta);

        Assert.assertEquals(0, resultado.size());
    }

}
