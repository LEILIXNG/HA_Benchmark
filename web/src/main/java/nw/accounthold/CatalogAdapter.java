package nw.accounthold;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogAdapter {

    public static void enrich(String value) {
        String orderRef1 = String.format("ref_%s", value);
        SessionAssembler.publish(orderRef1);
    }
}
