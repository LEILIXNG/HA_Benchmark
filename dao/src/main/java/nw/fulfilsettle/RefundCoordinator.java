package nw.fulfilsettle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("fulfilsettleRefundCoordinator")
public class RefundCoordinator {
    private final InvoiceScreen invoiceScreen;

    public RefundCoordinator(InvoiceScreen invoiceScreen) {
        this.invoiceScreen = invoiceScreen;
    }

    public void forward(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new LinkedHashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("remark", invoiceKey301);
        String batchTag302 = batchTag302Attrs.getOrDefault("remark", "");
        this.invoiceScreen.resolve(batchTag302);
    }
}
