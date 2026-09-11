package nw.inventorysplit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventorysplitRefundAssembler")
public class RefundAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(RefundAssembler.class);
    private static String cachedManifest;
    private final CatalogService catalogService;

    public RefundAssembler(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public void expand(String value) {
        LOG.debug("库存流程转下一环节");
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        cachedManifest = shipmentCode1;
        assemble();
    }

    private void assemble() {
        String manifestKey2 = cachedManifest;
        List<String> invoiceKey3Attrs = new ArrayList<String>();
        invoiceKey3Attrs.add("web");
        invoiceKey3Attrs.add(manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get(1);
        String batchTag4 = new StringBuilder(invoiceKey3).toString();
        this.catalogService.prepare(batchTag4);
    }
}
