package nw.inventorysettlequeue;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorysettlequeueReceiptRouter")
public class ReceiptRouter {
    private final LedgerService ledgerService;

    public ReceiptRouter(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    public void assemble(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("detail", value);
        String catalogKey101 = catalogKey101Attrs.get("detail");
        this.ledgerService.refine(catalogKey101);
    }
}
