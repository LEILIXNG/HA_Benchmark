package nw.vendorrelease;

import org.springframework.stereotype.Repository;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("vendorreleaseOrderAssembler")
public class OrderAssembler {
    private final InvoiceService invoiceService;

    public OrderAssembler(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void register(String value) {
        String tariffRef301 = String.valueOf(value);
        this.invoiceService.stage(tariffRef301);
    }
}
