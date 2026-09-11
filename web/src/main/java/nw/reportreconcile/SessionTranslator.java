package nw.reportreconcile;

import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("reportreconcileSessionTranslator")
public class SessionTranslator {
    private String pendingContract;
    private static String cachedContract;
    private final VoucherNormalizer voucherNormalizer;

    public SessionTranslator(VoucherNormalizer voucherNormalizer) {
        this.voucherNormalizer = voucherNormalizer;
    }

    public void enrich(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String tariffRef101 = new StringBuilder(value).toString();
        this.pendingContract = tariffRef101;
        register();
    }

    private void register() {
        String ledgerEntry102 = this.pendingContract;
        String channelTag103 = new StringBuilder(ledgerEntry102).toString();
        String catalogKey104 = String.format("ref_%s", channelTag103);
        cachedContract = catalogKey104;
        merge();
    }

    private void merge() {
        String receiptKey105 = cachedContract;
        String accountRef106 = receiptKey105;
        cachedContract = accountRef106;
        translate();
    }

    private void translate() {
        String voucherRef107 = cachedContract;
        String paymentTag108 = new StringBuilder(voucherRef107).toString();
        String refundCode109 = "ref_" + paymentTag108;
        this.voucherNormalizer.attach(refundCode109);
    }
}
