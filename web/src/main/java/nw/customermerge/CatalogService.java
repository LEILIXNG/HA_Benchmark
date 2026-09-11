package nw.customermerge;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("customermergeCatalogService")
public class CatalogService {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);
    private static String cachedAccount;
    private final OrderService orderService;

    public CatalogService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void dispatch(String value) {
        LOG.debug("开始整理客户字段");
        Map<String, String> accountRef1Attrs = new LinkedHashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("detail", value);
        String accountRef1 = accountRef1Attrs.getOrDefault("detail", "");
        cachedAccount = accountRef1;
        collect();
    }

    private void collect() {
        String voucherRef2 = cachedAccount;
        String paymentTag3 = new StringBuilder(voucherRef2).toString();
        String refundCode4 = paymentTag3;
        this.orderService.expand(refundCode4);
    }
}
