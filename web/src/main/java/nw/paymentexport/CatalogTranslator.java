package nw.paymentexport;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentexportCatalogTranslator")
public class CatalogTranslator {

    public void register(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("detail", value);
        String catalogKey1 = catalogKey1Attrs.get("detail");
        StringBuilder receiptKey2Buffer = new StringBuilder("ref_");
        receiptKey2Buffer.append(catalogKey1);
        String receiptKey2 = receiptKey2Buffer.toString();
        ShipmentBroker.resolve(receiptKey2);
    }
}
