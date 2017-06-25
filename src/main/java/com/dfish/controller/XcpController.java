package com.dfish.controller;

import com.dfish.domain.entity.Xuanchuanpin;
import com.dfish.domain.repository.XcpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

@RestController
@RequestMapping("/xcp")
public class XcpController {

    @Autowired
    private XcpRepository repository;

    @GetMapping("/all")
    public  List<Xuanchuanpin> readAll(){
        List<Xuanchuanpin> xcp = repository.findAll();
        return xcp;
    }

    @GetMapping("/title")
    public List<Xuanchuanpin> findbytitle(String title,String makestyle,String commonAdvise){
        List<Xuanchuanpin> xcp = repository.findbytitle("%"+title+"%","%"+makestyle+"%",commonAdvise+"%");
        return  xcp;
    }

    @DeleteMapping("/{id}")
    public  Boolean delete(@PathVariable long id){
        repository.delete(id);
        return true;
    }

    @PostMapping
    public Boolean create(@RequestBody Xuanchuanpin xcp) {
        repository.save(xcp);
        return true;
    }

    @GetMapping("/{id}")
    public Xuanchuanpin readById(@PathVariable long id) {
        Xuanchuanpin xcp = repository.findOne(id);
        return xcp;
    }

    @PutMapping("update")
    public Boolean update(@RequestBody Xuanchuanpin entity) {
        repository.save(entity);
        return true;
    }

}
