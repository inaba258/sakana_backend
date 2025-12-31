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
                .baseUrl("https://trial.api.info.gbiz.go.jp/hojin/")//trial=2gatsu
                .build();
    }
    public Hojinreceive searcher(String companyName, int pageNo) {
        String encodedName = java.net.URLEncoder.encode(companyName, java.nio.charset.StandardCharsets.UTF_8);

        System.out.println("今使っているトークンの先頭: " + gbizNoToken.substring(0, 5));
        String uriPath = "v2/hojin?name=" + encodedName + "&page=" + pageNo;// + "&limit ;

        Hojinreceive kekka = client.get()
                .uri(uriPath)
                .header("X-hojinInfo-api-token", gbizNoToken)
                .retrieve()
                .body(Hojinreceive.class);




       // if (kekka == null) {

       // }

        return kekka;
    }

    public Hojinreceive onecompany(String hojinBango) {

        String urlPath = "v2/hojin" + hojinBango;

        Hojinreceive syosaiData = client.get()
                .uri(urlPath)
                .header("X-hojinInfo-api-token", gbizNoToken)
                .retrieve()
                .body(Hojinreceive.class);

        return syosaiData;
    }
}