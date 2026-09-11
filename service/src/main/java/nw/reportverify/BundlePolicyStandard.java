package nw.reportverify;

/**
 * 报表的默认处理策略。
 */
public final class BundlePolicyStandard implements BundlePolicy {

    @Override
    public void handle(String value) {
        QuoteAdapter.submit(value);
    }
}
