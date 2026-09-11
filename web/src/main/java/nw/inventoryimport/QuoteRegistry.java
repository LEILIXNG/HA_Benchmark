package nw.inventoryimport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("inventoryimportQuoteRegistry")
public class QuoteRegistry {
    private static String cachedOrder;
    private final ContractTranslator contractTranslator;

    public QuoteRegistry(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    public void translate(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.get("detail");
        List<String> voucherRef2Attrs = new ArrayList<String>();
        voucherRef2Attrs.add("web");
        voucherRef2Attrs.add(accountRef1);
        String voucherRef2 = voucherRef2Attrs.get(1);
        cachedOrder = voucherRef2;
        forward();
    }

    private void forward() {
        String paymentTag3 = cachedOrder;
        String refundCode4 = paymentTag3;
        this.contractTranslator.resolve(refundCode4);
    }
}
