package nw.customerposting;

/**
 * 客户的默认处理策略。
 */
public final class AccountStrategyStandard implements AccountStrategy {

    @Override
    public void handle(String value) {
        InvoiceBuilder.refine(value);
    }
}
