package com.dfish.controller;

import com.dfish.domain.entity.xcleibie;
import com.dfish.domain.repository.xclbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

@RestController
@RequestMapping("/xclb")
public class XclbController {

    @Autowired
    private xclbRepository repository;

    @GetMapping("/all")
    public List<xcleibie> readAll() {
        List<xcleibie> xcxx = repository.findAll();
        return xcxx;
    }

    @PostMapping
    public Boolean create(@RequestBody xcleibie xclb) {
        repository.save(xclb);
        return true;
    }


}


