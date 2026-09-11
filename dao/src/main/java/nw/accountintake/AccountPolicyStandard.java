package nw.accountintake;

/**
 * 账户的默认处理策略。
 */
public final class AccountPolicyStandard implements AccountPolicy {

    @Override
    public void handle(String value) {
        VoucherNormalizer.stage(value);
    }
}
