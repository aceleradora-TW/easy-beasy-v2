package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.service.NetPromoterScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NetPromoterScoreController {
    NetPromoterScoreService netPromoterScoreService;

    @Autowired
    public NetPromoterScoreController(NetPromoterScoreService netPromoterScoreService) {
        this.netPromoterScoreService = netPromoterScoreService;
    }
}
