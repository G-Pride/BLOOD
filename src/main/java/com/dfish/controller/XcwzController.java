package com.dfish.controller;

import com.dfish.domain.entity.Xuanchuanwzly;
import com.dfish.domain.repository.XcwzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@RestController
@RequestMapping("/xcwz")
public class XcwzController {

    @Autowired
    private XcwzRepository repository;

    @GetMapping("/all")
    public List<Xuanchuanwzly> readAll(){
        List<Xuanchuanwzly> xcwz = repository.findAll();
        return xcwz;
    }

    @PostMapping
    public Boolean create(@RequestBody Xuanchuanwzly xcwz) {
        repository.save(xcwz);
        return true;
    }

    @GetMapping("/{id}")
    public Xuanchuanwzly readById(@PathVariable long id) {
        Xuanchuanwzly xcwz = repository.findOne(id);
        return xcwz;
    }

    @GetMapping("/title")
    public List<Xuanchuanwzly> findbytitle(String title,String ispass){
        List<Xuanchuanwzly> xcwz = repository.findbytitle("%"+title+"%",ispass+"%");
        return  xcwz;
    }

    @DeleteMapping("/{id}")
    public  Boolean delete(@PathVariable long id){
        repository.delete(id);
        return true;
    }

    @PutMapping("update")
    public Boolean update(@RequestBody Xuanchuanwzly entity) {
        repository.save(entity);
        return true;
    }
}
