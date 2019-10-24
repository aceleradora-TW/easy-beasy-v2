package com.thoughtworks.aceleradora.servicos;

import com.thoughtworks.aceleradora.dominio.Pergunta;
import com.thoughtworks.aceleradora.repositorio.PerguntaRepository;
import com.thoughtworks.aceleradora.servicos.PerguntaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PerguntaServiceTest {

    @Mock
    private PerguntaRepository perguntaRepository;

    @InjectMocks
    private PerguntaService perguntaService;

    @Test
    public void foo() {
        Pergunta pergunta = new Pergunta(1, "Sei lá?");

        Mockito.when(perguntaRepository.salvar(pergunta)).thenReturn(Arrays.asList(pergunta));

        List<Pergunta> resultado = perguntaService.salvar(pergunta);

        Pergunta perguntaResultado = resultado.get(0);
        Assert.assertEquals(pergunta.getOrdem(), perguntaResultado.getOrdem());
        Assert.assertEquals(pergunta.getDescricao(), perguntaResultado.getDescricao());

    }

}
