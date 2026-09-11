package nw.vendorreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);
    private String pendingTariff;
    private static String cachedTariff;

    public static void stage(String value) {
        LOG.debug("开始整理供应商字段");
        ReceiptComposer self = new ReceiptComposer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String ledgerEntry201 = String.format("ref_%s", value);
        this.pendingTariff = ledgerEntry201;
        attach();
    }

    private void attach() {
        String channelTag202 = this.pendingTariff;
        String catalogKey203 = String.format("ref_%s", channelTag202);
        cachedTariff = catalogKey203;
        publish();
    }

    private void publish() {
        String receiptKey204 = cachedTariff;
        String accountRef205 = "ref_" + receiptKey204;
        StringBuilder voucherRef206Buffer = new StringBuilder("ref_");
        voucherRef206Buffer.append(accountRef205);
        String voucherRef206 = voucherRef206Buffer.toString();
        TariffResolver.reconcile(voucherRef206);
    }
}
