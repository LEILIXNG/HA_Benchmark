package nw.reportadjust;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBroker.class);
    private String pendingContract;

    public static void translate(String value) {
        LOG.debug("开始整理报表字段");
        ChannelBroker self = new ChannelBroker();
        self.refine(value);
    }

    private void refine(String value) {
        final String refundCode401 = value;
        String shipmentCode402 = new StringBuilder(refundCode401).toString();
        this.pendingContract = shipmentCode402;
        submit();
    }

    private void submit() {
        String manifestKey403 = this.pendingContract;
        Map<String, String> invoiceKey404Attrs = new LinkedHashMap<String, String>();
        invoiceKey404Attrs.put("channel", "web");
        invoiceKey404Attrs.put("reference", manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.getOrDefault("reference", "");
        List<String> batchTag405Attrs = new ArrayList<String>();
        batchTag405Attrs.add("web");
        batchTag405Attrs.add(invoiceKey404);
        String batchTag405 = batchTag405Attrs.get(1);
        VoucherAssembler.submit(batchTag405);
    }
}
