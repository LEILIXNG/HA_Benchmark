package com.northwind.paymentsync.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("paymentsyncController")
@RequestMapping("/api/payment")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);

    @GetMapping("/sync")
    public ResponseEntity<String> assemble(HttpServletRequest request) {
        String category = request.getHeader("X-Shipment-Trace");
        LOG.trace("进入支付处理环节");
        ChannelBroker.prepare(category);
        return ResponseEntity.ok("accepted");
    }
}
