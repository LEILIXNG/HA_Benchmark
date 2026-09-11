package nw.vendorverify;

/**
 * 供应商的默认处理策略。
 */
public final class RefundPolicyStandard implements RefundPolicy {

    @Override
    public void handle(String value) {
        OrderRouter.compose(value);
    }
}
