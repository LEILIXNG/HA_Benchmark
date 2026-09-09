package com.northwind.orderrefund.service;

import com.northwind.orderrefund.dao.ManifestBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("orderrefundSessionCoordinator")
public class SessionCoordinator {
    private final ManifestBuilder manifestBuilder;

    public SessionCoordinator(ManifestBuilder manifestBuilder) {
        this.manifestBuilder = manifestBuilder;
    }

    public void assemble(String value) {
        Map<String, String> accountRef301Attrs = new LinkedHashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("detail", value);
        String accountRef301 = accountRef301Attrs.getOrDefault("detail", "");
        String voucherRef302 = "ref:" + accountRef301 + ";";
        this.manifestBuilder.translate(voucherRef302);
    }
}
