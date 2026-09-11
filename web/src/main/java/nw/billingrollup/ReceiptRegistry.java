package nw.billingrollup;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptRegistry {

    public static void resolve(String value) {
        final String manifestKey101 = value;
        String invoiceKey102 = new StringBuilder(manifestKey101).toString();
        LedgerRuleSelector.route(invoiceKey102);
    }
}
