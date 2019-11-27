package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.service.NetPromoterScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/net-promoter-score")
public class NetPromoterScoreController {
    private NetPromoterScoreService netPromoterScoreService;

    public NetPromoterScoreController(NetPromoterScoreService netPromoterScoreService) {
        this.netPromoterScoreService = netPromoterScoreService;
    }

    @PostMapping("/")
    public Optional<NetPromoterScore> save(@RequestBody NetPromoterScore netPromoterScore) {
        return netPromoterScoreService.save(netPromoterScore);
    }
}

