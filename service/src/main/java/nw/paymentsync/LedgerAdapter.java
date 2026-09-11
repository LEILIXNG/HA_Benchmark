package nw.paymentsync;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerAdapter {

    public static void stage(String value) {
        String shipmentCode101 = String.valueOf(value);
        String manifestKey102 = shipmentCode101;
        RefundPolicy.stage(manifestKey102);
    }
}
