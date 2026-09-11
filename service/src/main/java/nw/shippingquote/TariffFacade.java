package nw.shippingquote;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingquoteTariffFacade")
public class TariffFacade {
    private static final Logger LOG = LoggerFactory.getLogger(TariffFacade.class);
    private final ContractStrategySelector contractStrategySelector;

    public TariffFacade(ContractStrategySelector contractStrategySelector) {
        this.contractStrategySelector = contractStrategySelector;
    }

    public void enrich(String value) {
        LOG.debug("接收到一次发运处理请求");
        String manifestKey101 = new StringBuilder(value).toString();
        Map<String, String> invoiceKey102Attrs = new LinkedHashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("remark", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.getOrDefault("remark", "");
        this.contractStrategySelector.normalize(invoiceKey102);
    }
}
