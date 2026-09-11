package nw.catalogrenewal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogrenewalLedgerRouter")
public class LedgerRouter {
    private String pendingContract;
    private final ManifestService manifestService;

    public LedgerRouter(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    public void normalize(String value) {
        this.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> catalogKey201Attrs = new LinkedHashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.getOrDefault("detail", "");
        this.pendingContract = catalogKey201;
        collect();
    }

    private void collect() {
        String receiptKey202 = this.pendingContract;
        Map<String, String> accountRef203Attrs = new HashMap<String, String>();
        accountRef203Attrs.put("channel", "web");
        accountRef203Attrs.put("note", receiptKey202);
        String accountRef203 = accountRef203Attrs.get("note");
        final String voucherRef204 = accountRef203;
        this.manifestService.assemble(voucherRef204);
    }
}
