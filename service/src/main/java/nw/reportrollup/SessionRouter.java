package nw.reportrollup;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("reportrollupSessionRouter")
public class SessionRouter {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRouter.class);
    private String pendingAccount;
    private static String cachedAccount;
    private final InvoiceNormalizer invoiceNormalizer;

    public SessionRouter(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    public void dispatch(String value) {
        LOG.debug("报表流程转下一环节");
        this.translate(value);
    }

    private void translate(String value) {
        String tariffRef201 = new StringBuilder(value).toString();
        cachedAccount = tariffRef201;
        forward();
    }

    private void forward() {
        String ledgerEntry202 = cachedAccount;
        List<String> channelTag203Attrs = new ArrayList<String>();
        channelTag203Attrs.add("web");
        channelTag203Attrs.add(ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get(1);
        String catalogKey204 = "ref_".concat(channelTag203);
        this.pendingAccount = catalogKey204;
        normalize();
    }

    private void normalize() {
        String receiptKey205 = this.pendingAccount;
        String accountRef206 = "ref_".concat(receiptKey205);
        this.pendingAccount = accountRef206;
        compose();
    }

    private void compose() {
        String voucherRef207 = this.pendingAccount;
        String paymentTag208 = new StringBuilder(voucherRef207).toString();
        this.invoiceNormalizer.collect(paymentTag208);
    }
}
