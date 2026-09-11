package nw.vendoradjust;

import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendoradjustVoucherPolicy")
public class VoucherPolicy {
    private final InvoiceGateway invoiceGateway;

    public VoucherPolicy(InvoiceGateway invoiceGateway) {
        this.invoiceGateway = invoiceGateway;
    }

    public void refine(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replaceAll("'", "");
        this.invoiceGateway.refine(cleaned);
    }
}
