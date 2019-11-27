package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.repository.NetPromoterScoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class NPSTest {
    @Mock
    private NetPromoterScoreRepository repository;

    @InjectMocks
    private NetPromoterScoreService netPromoterScoreService;

    @Test
    public void shouldReturnEmptyOptionalIfNPSHasNoScore(){
        NetPromoterScore netPromoterScore = new NetPromoterScore();

        assertEquals(Optional.empty(),netPromoterScoreService.save(netPromoterScore));
        Mockito.verifyZeroInteractions(repository);
    }

}
