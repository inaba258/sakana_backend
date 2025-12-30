package com.example.apback1;
import com.example.apback1.dto.Hojinreceive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ServiceG {

    @Value("${X-hojinInfo-api-token}")
    private String gbizNoToken;
    private final RestClient client;

    public ServiceG(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("https://info.gbiz.go.jp/hojin/v1")//v2 tokamo
                .build();
    }
    public Hojinreceive searcher(String companyName, int pageNo) {
        String url = "/hojin?name=" + companyName + "&limit=20&page=" + pageNo; //1520増やしてもええかも

        Hojinreceive kekka = client.get()
                .uri(url)
                .header("X-hojinInfo-api-token", gbizNoToken)
                .retrieve()
                .body(Hojinreceive.class);

       // if (kekka == null) {

       // }

        return kekka;
    }

    public Hojinreceive onecompany(String hojinBango) {

        String urlPath = "/hojin/" + hojinBango;

        Hojinreceive syosaiData = client.get()
                .uri(urlPath)
                .header("X-hojinInfo-api-token", gbizNoToken)
                .retrieve()
                .body(Hojinreceive.class);

        return syosaiData;
    }
}