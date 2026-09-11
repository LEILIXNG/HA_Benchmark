package nw.vendortrace;

/**
 * 供应商明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class InvoiceCoordinator {

    public static void attach(String value) {
        String receiptKey101 = String.valueOf(value);
        SessionEnricher.prepare(receiptKey101);
    }
}
