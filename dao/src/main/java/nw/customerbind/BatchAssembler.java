package nw.customerbind;

/**
 * 客户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BatchAssembler {

    public static void collect(String value) {
        final String accountRef401 = value;
        String voucherRef402 = new StringBuilder(accountRef401).toString();
        ReceiptFetcher.route(voucherRef402);
    }
}
