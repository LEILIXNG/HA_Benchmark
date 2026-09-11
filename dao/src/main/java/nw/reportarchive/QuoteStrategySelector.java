package nw.reportarchive;

/**
 * 报表处理策略的入口。
 */
public final class QuoteStrategySelector {

    public static void compose(String value) {
        QuoteStrategy handler = dispatch();
        handler.handle(value);
    }

    private static QuoteStrategy dispatch() {
        return new QuoteStrategyStandard();
    }
}
