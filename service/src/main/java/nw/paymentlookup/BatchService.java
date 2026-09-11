package nw.paymentlookup;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BatchService {

    public static void forward(String value) {
        String paymentTag101 = value;
        String refundCode102 = String.format("ref_%s", paymentTag101);
        ChannelCoordinator.merge(refundCode102);
    }
}
