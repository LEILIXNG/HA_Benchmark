package com.northwind.cataloggrant.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("cataloggrantController")
@RequestMapping("/api/catalog")
public class ManifestController {
    private final TariffNormalizer tariffNormalizer;

    public ManifestController(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    @GetMapping("/grant/{token}")
    public ResponseEntity<String> refine(
            @PathVariable("token") String token) {
        this.tariffNormalizer.expand(token);
        return ResponseEntity.ok("accepted");
    }
}
