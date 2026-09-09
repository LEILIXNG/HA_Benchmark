package com.northwind.fulfildispatch.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfildispatchController")
public class ChannelController {

    @GetMapping("/api/fulfil/dispatch/{userName}")
    public ResponseEntity<String> resolve(
            @PathVariable("userName") String userName) {
        BatchValidator.resolve(userName);
        return ResponseEntity.ok("ok");
    }
}
