package nw.reportrenewal;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 报表受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("reportrenewalReceiptBroker")
public class ReceiptBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBroker.class);
    private static String cachedVoucher;
    private final VoucherFetcher voucherFetcher;

    public ReceiptBroker(VoucherFetcher voucherFetcher) {
        this.voucherFetcher = voucherFetcher;
    }

    public void route(String value) {
        LOG.trace("进入报表处理环节");
        String catalogKey201 = String.valueOf(value);
        cachedVoucher = catalogKey201;
        refine();
    }

    private void refine() {
        String receiptKey202 = cachedVoucher;
        String accountRef203 = String.valueOf(receiptKey202);
        cachedVoucher = accountRef203;
        attach();
    }

    private void attach() {
        String voucherRef204 = cachedVoucher;
        List<String> paymentTag205Attrs = new ArrayList<String>();
        paymentTag205Attrs.add("web");
        paymentTag205Attrs.add(voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get(1);
        this.voucherFetcher.publish(paymentTag205);
    }
}
