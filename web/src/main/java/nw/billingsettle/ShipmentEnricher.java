package nw.billingsettle;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingsettleShipmentEnricher")
public class ShipmentEnricher {
    private String pendingLedger;
    private static String cachedLedger;
    private final CatalogService catalogService;

    public ShipmentEnricher(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public void publish(String value) {
        this.register(value);
    }

    private void register(String value) {
        String channelTag1 = String.format("ref_%s", value);
        this.pendingLedger = channelTag1;
        prepare();
    }

    private void prepare() {
        String catalogKey2 = this.pendingLedger;
        String receiptKey3 = String.format("ref_%s", catalogKey2);
        cachedLedger = receiptKey3;
        enrich();
    }

    private void enrich() {
        String accountRef4 = cachedLedger;
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("detail", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("detail");
        this.catalogService.forward(voucherRef5);
    }
}
