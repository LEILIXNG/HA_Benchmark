package nw.accountreopen;

/**
 * 账户的默认处理策略。
 */
public final class VoucherStrategyStandard implements VoucherStrategy {

    @Override
    public void handle(String value) {
        SessionNormalizer.submit(value);
    }
}
