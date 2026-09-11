package nw.paymentimport;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractNormalizer {

    public static void reconcile(String value) {
        String manifestKey101 = String.valueOf(value);
        BatchCollector.dispatch(manifestKey101);
    }
}
