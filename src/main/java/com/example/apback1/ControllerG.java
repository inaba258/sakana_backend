package com.example.apback1;

import com.example.apback1.dto.Hojinreceive;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerG {
    private final ServiceG serviceG;
    public ControllerG(ServiceG serviceG) {
        this.serviceG = serviceG;
    }


    @GetMapping("/search")
    public Hojinreceive getSearch(@RequestParam String name, @RequestParam int page) {

        return serviceG.searcher(name, page);
    }

    @GetMapping("/detail/{bango}")
    public Hojinreceive getOne(@PathVariable String bango) {;

        return serviceG.onecompany(bango);
    }
}

