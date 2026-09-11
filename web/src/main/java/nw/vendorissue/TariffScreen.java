package nw.vendorissue;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffScreen {

    public static void submit(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value;
        if (cleaned.indexOf("../") >= 0) {
            cleaned = cleaned.replace("../", "");
        }
        PaymentLoader.collect(cleaned);
    }
}
