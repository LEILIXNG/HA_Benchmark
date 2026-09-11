package nw.orderimport;

/**
 * 订单的默认处理策略。
 */
public final class ManifestRuleStandard implements ManifestRule {

    @Override
    public void handle(String value) {
        VoucherResolver.reconcile(value);
    }
}
