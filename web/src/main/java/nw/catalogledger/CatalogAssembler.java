package nw.catalogledger;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogledgerCatalogAssembler")
public class CatalogAssembler {
    private final VoucherStrategySelector voucherStrategySelector;

    public CatalogAssembler(VoucherStrategySelector voucherStrategySelector) {
        this.voucherStrategySelector = voucherStrategySelector;
    }

    public void publish(String value) {
        Map<String, String> accountRef1Attrs = new LinkedHashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.getOrDefault("detail", "");
        this.voucherStrategySelector.prepare(accountRef1);
    }
}
