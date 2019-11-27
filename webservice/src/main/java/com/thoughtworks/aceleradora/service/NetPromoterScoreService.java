package com.thoughtworks.aceleradora.service;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.repository.NetPromoterScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NetPromoterScoreService {

    private NetPromoterScoreRepository repository;

    public NetPromoterScoreService(NetPromoterScoreRepository repository) {
        this.repository = repository;
    }

    public Optional<NetPromoterScore> save(NetPromoterScore netPromoterScore) {
        return netPromoterScore.getScore() >= 1
                ? Optional.ofNullable(repository.save(netPromoterScore))
                : Optional.empty();

    }
}
