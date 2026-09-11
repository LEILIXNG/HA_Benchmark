package nw.cataloggrant;

/**
 * 商品的默认处理策略。
 */
public final class QuotePolicyStandard implements QuotePolicy {

    @Override
    public void handle(String value) {
        QuoteComposer.route(value);
    }
}
