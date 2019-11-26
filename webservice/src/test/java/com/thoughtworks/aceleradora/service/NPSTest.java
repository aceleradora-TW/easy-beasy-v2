package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.repository.NetPromoterScoreRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class NPSTest {
    @Mock
    private NetPromoterScoreRepository repository;

    @InjectMocks
    private NetPromoterScoreService netPromoterScoreService;

    @Test
    public void shouldReturnNullIfNPSHasNoScore(){
        NetPromoterScore netPromoterScore = new NetPromoterScore();

        Assert.assertNull(netPromoterScoreService.save(netPromoterScore));
        Mockito.verifyZeroInteractions(repository);
    }

}
