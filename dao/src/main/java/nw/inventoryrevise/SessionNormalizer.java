package nw.inventoryrevise;

/**
 * 面向库存场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class SessionNormalizer {

    public static void stage(String value) {
        String receiptKey201 = new StringBuilder(value).toString();
        LedgerValidator.normalize(receiptKey201);
    }
}
