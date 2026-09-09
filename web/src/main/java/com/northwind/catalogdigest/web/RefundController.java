package com.northwind.catalogdigest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("catalogdigestController")
public class RefundController {

    @GetMapping("/api/catalog/digest")
    public ResponseEntity<String> normalize(
            @RequestHeader("X-Refund-Origin") String category) {
        ChannelTranslator.forward(category);
        return ResponseEntity.ok("done");
    }
}
