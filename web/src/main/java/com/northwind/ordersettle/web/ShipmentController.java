package com.northwind.ordersettle.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("ordersettleController")
@RequestMapping("/api/order")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final ChannelTranslator channelTranslator;

    public ShipmentController(ChannelTranslator channelTranslator) {
        this.channelTranslator = channelTranslator;
    }

    @GetMapping("/settle")
    public ResponseEntity<String> forward(
            @RequestParam("tag") String tag) {
        LOG.trace("进入订单处理环节");
        this.channelTranslator.translate(tag);
        return ResponseEntity.ok("done");
    }
}
