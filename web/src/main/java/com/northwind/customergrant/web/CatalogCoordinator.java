package com.northwind.customergrant.web;

import com.northwind.customergrant.service.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customergrantCatalogCoordinator")
public class CatalogCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCoordinator.class);

    public void forward(String value) {
        LOG.debug("接收到一次客户处理请求");
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        String ledgerEntry2 = "ref:".concat(tariffRef1).concat(";");
        QuoteAssembler.assemble(ledgerEntry2);
    }
}
