package nw.reportverify;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentNormalizer {

    public static void prepare(String value) {
        final String receiptKey101 = value;
        CatalogService.compose(receiptKey101);
    }
}
