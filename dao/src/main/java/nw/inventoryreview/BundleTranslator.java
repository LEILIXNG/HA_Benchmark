package nw.inventoryreview;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BundleTranslator {

    public static void dispatch(String value) {
        String invoiceKey401 = new StringBuilder(value).toString();
        InvoiceFilter.dispatch(invoiceKey401);
    }
}
