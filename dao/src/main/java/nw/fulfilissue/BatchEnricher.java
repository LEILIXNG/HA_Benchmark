package nw.fulfilissue;

/**
 * 履约处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchEnricher {
    private String pendingPayment;

    public static void normalize(String value) {
        BatchEnricher self = new BatchEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag401 = String.valueOf(value);
        this.pendingPayment = channelTag401;
        submit();
    }

    private void submit() {
        String catalogKey402 = this.pendingPayment;
        String receiptKey403 = String.valueOf(catalogKey402);
        PaymentGateway.stage(receiptKey403);
    }
}
