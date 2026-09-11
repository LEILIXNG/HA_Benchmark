package nw.billingrenewal;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentAssembler {
    private static String cachedInvoice;

    public static void collect(String value) {
        cachedInvoice = value;
        reconcile();
    }

    private static void reconcile() {
        String accountRef401 = cachedInvoice;
        ShipmentNormalizer.merge(accountRef401);
    }
}
