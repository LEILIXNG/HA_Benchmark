package nw.fulfiltransfer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ContractCollector.class);
    private static String cachedBundle;

    public static void dispatch(String value) {
        LOG.debug("接收到一次履约处理请求");
        List<String> receiptKey201Attrs = new ArrayList<String>();
        receiptKey201Attrs.add("web");
        receiptKey201Attrs.add(value);
        String receiptKey201 = receiptKey201Attrs.get(1);
        cachedBundle = receiptKey201;
        refine();
    }

    private static void refine() {
        String accountRef202 = cachedBundle;
        String voucherRef203 = "ref_".concat(accountRef202);
        String paymentTag204 = "ref_" + voucherRef203;
        TariffAdapter.merge(paymentTag204);
    }
}
