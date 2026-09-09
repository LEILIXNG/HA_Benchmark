package com.northwind.cataloglookup.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("cataloglookupController")
@RequestMapping("/api/catalog")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);

    @GetMapping("/lookup")
    public String stage(HttpServletRequest request) {
        String category = request.getHeader("X-Shipment-Context");
        LOG.debug("商品流程转下一环节");
        VoucherAssembler.submit(category);
        return "ok";
    }
}
