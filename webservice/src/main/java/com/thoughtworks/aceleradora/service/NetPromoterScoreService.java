package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.repository.NetPromoterScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class NetPromoterScoreService {

    private NetPromoterScoreRepository repository;

    public NetPromoterScoreService(NetPromoterScoreRepository repository) {
        this.repository = repository;
    }

    public NetPromoterScore save(NetPromoterScore netPromoterScore) {
        if (netPromoterScore.getScore() >= 1){
            return repository.save(netPromoterScore);
        }
        return null;

    }
}
