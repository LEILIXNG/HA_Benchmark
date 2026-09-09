package com.northwind.catalogquote.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("catalogquoteController")
@RequestMapping("/api/catalog")
public class TariffController {
    private final QuoteNormalizer quoteNormalizer;

    public TariffController(QuoteNormalizer quoteNormalizer) {
        this.quoteNormalizer = quoteNormalizer;
    }

    @GetMapping("/quote")
    public String refine(
            @RequestParam("target") String target) {
        this.quoteNormalizer.register(target);
        return "ok";
    }
}
