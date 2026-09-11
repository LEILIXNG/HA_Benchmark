package nw.shippinghold;

/**
 * 发运的默认处理策略。
 */
public final class InvoicePolicyStandard implements InvoicePolicy {

    @Override
    public void handle(String value) {
        ReceiptFacade.refine(value);
    }
}
