package com.northwind.billingclose.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("billingcloseController")
public class ShipmentController {
    private final CatalogAdapter catalogAdapter;

    public ShipmentController(CatalogAdapter catalogAdapter) {
        this.catalogAdapter = catalogAdapter;
    }

    @GetMapping("/api/billing/close")
    public String dispatch(HttpServletRequest request) {
        String userName = request.getHeader("X-Shipment-Correlation");
        this.catalogAdapter.assemble(userName);
        return "done";
    }
}
