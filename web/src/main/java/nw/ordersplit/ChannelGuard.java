package nw.ordersplit;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelGuard {

    public static void prepare(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.contains("'") ? value.replace("'", "") : value;
        ReceiptRepository.stage(cleaned);
    }
}
