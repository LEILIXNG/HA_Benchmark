package nw.fulfilreopen;

/**
 * 履约的默认处理策略。
 */
public final class VoucherPolicyStandard implements VoucherPolicy {

    @Override
    public void handle(String value) {
        InvoiceComposer.publish(value);
    }
}
