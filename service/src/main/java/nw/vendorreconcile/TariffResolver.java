package nw.vendorreconcile;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffResolver {

    public static void reconcile(String value) {
        String invoiceKey301 = String.valueOf(value);
        TariffRepository.stage(invoiceKey301);
    }
}
