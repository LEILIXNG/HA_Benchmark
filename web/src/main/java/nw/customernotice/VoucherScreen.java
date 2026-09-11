package nw.customernotice;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherScreen {

    public static void expand(String value) {
        // 历史脚本里带分号会切断参数，先删掉
        String cleaned = value.contains(";") ? value.replace(";", "") : value;
        RefundExecutor.route(cleaned);
    }
}
