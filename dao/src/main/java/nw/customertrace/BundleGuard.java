package nw.customertrace;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BundleGuard {

    public static void submit(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        ReceiptFetcher.enrich(value);
    }
}
