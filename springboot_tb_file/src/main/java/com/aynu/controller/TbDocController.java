package com.aynu.controller;


import com.aynu.entity.TbDoc;
import com.aynu.service.TbDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tbdoc")
public class TbDocController {

    @Autowired
    private TbDocService tbDocService;

    @GetMapping("/findAll")
    public List<TbDoc> findAll(){
        return tbDocService.list();
    }

    @GetMapping("/find/{id}")
    public List<TbDoc> findById(@PathVariable Integer id){
        return tbDocService.findById(id);
    }

    @PostMapping("/copy/{kid}/{parent}")
    public String copy(@PathVariable(value = "kid") Integer kid, @PathVariable(value = "parent") Integer parent){
        if(tbDocService.getById(parent).getType() == 1){
            return "不可复制到文件中，只能复制到文件夹！";
        }
        int tempKid = kid;
        while (  tempKid != parent){
            if(tempKid == -1) break;
            tempKid = tbDocService.getById(tempKid).getPid();
        }
        if(tempKid == parent || tempKid == -1){
            return "父级目录不可复制到子级目录！";
        }
        tbDocService.copy(kid,parent);
        return "复制成功！";
    }

}
