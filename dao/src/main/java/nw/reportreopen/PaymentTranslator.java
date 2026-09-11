package nw.reportreopen;

import org.springframework.stereotype.Repository;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("reportreopenPaymentTranslator")
public class PaymentTranslator {
    private final OrderPlanSelector orderPlanSelector;

    public PaymentTranslator(OrderPlanSelector orderPlanSelector) {
        this.orderPlanSelector = orderPlanSelector;
    }

    public void enrich(String value) {
        StringBuilder invoiceKey301Buffer = new StringBuilder("ref_");
        invoiceKey301Buffer.append(value);
        String invoiceKey301 = invoiceKey301Buffer.toString();
        String batchTag302 = "ref_" + invoiceKey301;
        this.orderPlanSelector.register(batchTag302);
    }
}
