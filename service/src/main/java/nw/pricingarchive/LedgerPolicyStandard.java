package nw.pricingarchive;

/**
 * 定价的默认处理策略。
 */
public final class LedgerPolicyStandard implements LedgerPolicy {

    @Override
    public void handle(String value) {
        SessionNormalizer.merge(value);
    }
}
