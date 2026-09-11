package nw.shippingclose;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("shippingcloseContractEnricher")
public class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);
    private final OrderExecutor orderExecutor;

    public ContractEnricher(OrderExecutor orderExecutor) {
        this.orderExecutor = orderExecutor;
    }

    public void expand(String value) {
        LOG.debug("发运流程转下一环节");
        String channelTag501 = "ref_" + value;
        Map<String, String> catalogKey502Attrs = new LinkedHashMap<String, String>();
        catalogKey502Attrs.put("channel", "web");
        catalogKey502Attrs.put("remark", channelTag501);
        String catalogKey502 = catalogKey502Attrs.getOrDefault("remark", "");
        this.orderExecutor.collect(catalogKey502);
    }
}
