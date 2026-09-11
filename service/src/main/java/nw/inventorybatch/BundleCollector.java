package nw.inventorybatch;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("inventorybatchBundleCollector")
public class BundleCollector {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCollector.class);
    private final BatchTranslator batchTranslator;

    public BundleCollector(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    public void register(String value) {
        LOG.debug("开始整理库存字段");
        String refundCode201 = new StringBuilder(value).toString();
        Map<String, String> shipmentCode202Attrs = new LinkedHashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("remark", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.getOrDefault("remark", "");
        this.batchTranslator.forward(shipmentCode202);
    }
}
