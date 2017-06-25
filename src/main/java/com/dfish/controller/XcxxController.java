package com.dfish.controller;

import com.dfish.domain.entity.Xuanchuanmsg;
import com.dfish.domain.repository.XcxxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */

@RestController
@RequestMapping("/xcxxsq")
public class XcxxController {

    @Autowired
    private XcxxRepository repository;

    @GetMapping("/all")
    public  List<Xuanchuanmsg> readAll(){
        List<Xuanchuanmsg> xcxx = repository.findAll();
        return xcxx;
    }

    @GetMapping("/alldesc")
    public  List<Xuanchuanmsg> readAllDesc(){
        Sort sort = new Sort(Sort.Direction.DESC, "xcxxleibie");
        List<Xuanchuanmsg> xcxx = repository.findAll(sort);
        return xcxx;
    }

    @PostMapping
    public Boolean create(@RequestBody Xuanchuanmsg xcxx) {
        repository.save(xcxx);
        return true;
    }

    @GetMapping("/{id}")
    public Xuanchuanmsg readById(@PathVariable Long id) {
        Xuanchuanmsg xcxx = repository.findOne(id);
        return xcxx;
    }

    @GetMapping("/leibie")
    public  List<Xuanchuanmsg> findbyleibie(String leibie){
        List<Xuanchuanmsg> xcxx = repository.findbyleibie("%"+leibie+"%");
        return xcxx;
    }

    @DeleteMapping("/{id}")
    public  Boolean delete(@PathVariable Long id){
        repository.delete(id);
        return true;
    }

    @GetMapping("/title")
    public  List<Xuanchuanmsg> findbytitle(String title, String applytime,String xcxxleibie,String ispass){
        List<Xuanchuanmsg> xcxx = repository.findByOrgIdAndGroupId("%"+title+"%","%"+applytime+"%","%"+xcxxleibie+"%",ispass+"%");
        return xcxx;
    }

    @GetMapping("/lbmj")
    public  List<Xuanchuanmsg> findbylbmj(String xcxxleibie, String meijie){
        List<Xuanchuanmsg> xclb = repository.findBylbmj("%"+xcxxleibie+"%","%"+meijie+"%");
        return xclb;
    }

    @PutMapping("update")
    public Boolean update(@RequestBody Xuanchuanmsg entity) {
        repository.save(entity);
        return true;
    }

}
