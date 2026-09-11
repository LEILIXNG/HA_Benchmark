package nw.catalogsplit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogsplitReceiptService")
public class ReceiptService {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptService.class);
    private final OrderBuilder orderBuilder;

    public ReceiptService(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public void attach(String value) {
        LOG.debug("接收到一次商品处理请求");
        List<String> receiptKey1Attrs = new ArrayList<String>();
        receiptKey1Attrs.add("web");
        receiptKey1Attrs.add(value);
        String receiptKey1 = receiptKey1Attrs.get(1);
        StringBuilder accountRef2Buffer = new StringBuilder("ref_");
        accountRef2Buffer.append(receiptKey1);
        String accountRef2 = accountRef2Buffer.toString();
        this.orderBuilder.dispatch(accountRef2);
    }
}
