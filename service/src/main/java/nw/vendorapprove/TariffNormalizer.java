package nw.vendorapprove;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorapproveTariffNormalizer")
public class TariffNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(TariffNormalizer.class);
    private static String cachedReceipt;
    private final ChannelBuilder channelBuilder;

    public TariffNormalizer(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    public void merge(String value) {
        LOG.trace("进入供应商处理环节");
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.get("detail");
        String invoiceKey102 = manifestKey101;
        cachedReceipt = invoiceKey102;
        collect();
    }

    private void collect() {
        String batchTag103 = cachedReceipt;
        String orderRef104 = String.format("ref_%s", batchTag103);
        cachedReceipt = orderRef104;
        enrich();
    }

    private void enrich() {
        String quoteRef105 = cachedReceipt;
        final String tariffRef106 = quoteRef105;
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("note", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("note");
        this.channelBuilder.compose(ledgerEntry107);
    }
}
