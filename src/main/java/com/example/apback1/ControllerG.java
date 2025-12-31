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
        System.out.println("Androidから検索が来た！ 名前: " + name + " ページ: " + page);

        return serviceG.searcher(name, page);
    }

    @GetMapping("/detail/{bango}")
    public Hojinreceive getOne(@PathVariable String bango) {
        System.out.println("詳細が見たいらしい！ 番号: " + bango);

        return serviceG.onecompany(bango);
    }
}

