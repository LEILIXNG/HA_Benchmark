package nw.billingnotice;

/**
 * 账务受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractAdapter {

    public static void submit(String value) {
        String channelTag1 = String.format("ref_%s", value);
        ContractStrategySelector.publish(channelTag1);
    }
}
