package nw.customerledger;

/**
 * 客户处理策略的入口。
 */
public final class BatchPolicySelector {

    public static void attach(String value) {
        BatchPolicy handler = normalize();
        handler.handle(value);
    }

    private static BatchPolicy normalize() {
        return new BatchPolicyStandard();
    }
}
