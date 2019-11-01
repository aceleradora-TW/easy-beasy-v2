package com.thoughtworks.aceleradora.repository;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetPromoterScoreRepository extends CrudRepository<NetPromoterScore, Long> {
}
