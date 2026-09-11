package nw.paymentsettlequeue;

/**
 * 支付的默认处理策略。
 */
public final class ContractStrategyStandard implements ContractStrategy {

    @Override
    public void handle(String value) {
        OrderBroker.merge(value);
    }
}
