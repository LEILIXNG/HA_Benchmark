package nw.reportarchive;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("reportarchiveManifestTranslator2")
public class ManifestTranslator2 {
    private final ShipmentResolver shipmentResolver;

    public ManifestTranslator2(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    public void normalize(String value) {
        String accountRef1 = String.valueOf(value);
        Map<String, String> voucherRef2Attrs = new LinkedHashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("remark", accountRef1);
        String voucherRef2 = voucherRef2Attrs.getOrDefault("remark", "");
        this.shipmentResolver.enrich(voucherRef2);
    }
}
