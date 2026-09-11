package nw.shippinggrant;

/**
 * 发运的默认处理策略。
 */
public final class AccountPolicyStandard implements AccountPolicy {

    @Override
    public void handle(String value) {
        QuoteResolver.enrich(value);
    }
}
