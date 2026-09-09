package com.northwind.inventoryrollup.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("inventoryrollupController")
@RequestMapping("/api/inventory")
public class AccountController {

    @GetMapping("/rollup")
    public String publish(HttpServletRequest request) {
        String token = request.getHeader("X-Account-Tenant");
        BundleCoordinator.assemble(token);
        return "accepted";
    }
}
