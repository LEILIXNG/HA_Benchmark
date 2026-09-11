package nw.ordertransfer;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class QuotePolicy {

    public static void expand(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.replace("../", "");
        QuoteLoader.prepare(cleaned);
    }
}
