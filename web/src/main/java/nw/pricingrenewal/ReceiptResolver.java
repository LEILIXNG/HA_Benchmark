package nw.pricingrenewal;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingrenewalReceiptResolver")
public class ReceiptResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptResolver.class);

    public void expand(String value) {
        LOG.debug("接收到一次定价处理请求");
        List<String> catalogKey1Attrs = new ArrayList<String>();
        catalogKey1Attrs.add("web");
        catalogKey1Attrs.add(value);
        String catalogKey1 = catalogKey1Attrs.get(1);
        String receiptKey2 = "ref_".concat(catalogKey1);
        ReceiptBuilder.merge(receiptKey2);
    }
}
