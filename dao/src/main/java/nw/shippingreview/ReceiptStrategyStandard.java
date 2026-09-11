package nw.shippingreview;

/**
 * 发运的默认处理策略。
 */
public final class ReceiptStrategyStandard implements ReceiptStrategy {

    @Override
    public void handle(String value) {
        InvoiceAssembler.stage(value);
    }
}
