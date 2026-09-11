package nw.customerledger;

/**
 * 客户的默认处理策略。
 */
public final class BatchPolicyStandard implements BatchPolicy {

    @Override
    public void handle(String value) {
        VoucherCollector.expand(value);
    }
}
