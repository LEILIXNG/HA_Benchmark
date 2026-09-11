package nw.catalogrefund;

import org.springframework.stereotype.Service;

/**
 * 商品受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogrefundPaymentComposer")
public class PaymentComposer {
    private final LedgerService ledgerService;

    public PaymentComposer(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    public void refine(String value) {
        String invoiceKey201 = "ref_" + value;
        this.ledgerService.translate(invoiceKey201);
    }
}
