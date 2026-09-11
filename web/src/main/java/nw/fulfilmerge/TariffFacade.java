package nw.fulfilmerge;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilmergeTariffFacade")
public class TariffFacade {
    private static final Logger LOG = LoggerFactory.getLogger(TariffFacade.class);
    private String pendingInvoice;
    private final BatchEnricher batchEnricher;

    public TariffFacade(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    public void dispatch(String value) {
        LOG.debug("接收到一次履约处理请求");
        this.assemble(value);
    }

    private void assemble(String value) {
        String shipmentCode101 = String.valueOf(value);
        Map<String, String> manifestKey102Attrs = new LinkedHashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("remark", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.getOrDefault("remark", "");
        this.pendingInvoice = manifestKey102;
        translate();
    }

    private void translate() {
        String invoiceKey103 = this.pendingInvoice;
        final String batchTag104 = invoiceKey103;
        String orderRef105 = new StringBuilder(batchTag104).toString();
        this.batchEnricher.submit(orderRef105);
    }
}
