package nw.vendorreconcile;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorreconcileChannelBuilder")
public class ChannelBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBuilder.class);
    private final VoucherAdapter voucherAdapter;

    public ChannelBuilder(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    public void publish(String value) {
        LOG.debug("开始整理供应商字段");
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        String batchTag2 = invoiceKey1;
        this.voucherAdapter.reconcile(batchTag2);
    }
}
