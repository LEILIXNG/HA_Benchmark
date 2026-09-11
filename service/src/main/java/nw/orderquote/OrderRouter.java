package nw.orderquote;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class OrderRouter {

    public static void enrich(String value) {
        String accountRef201 = new StringBuilder(value).toString();
        ReceiptBroker.enrich(accountRef201);
    }
}
