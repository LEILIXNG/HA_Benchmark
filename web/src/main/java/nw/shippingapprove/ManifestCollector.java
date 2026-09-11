package nw.shippingapprove;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("shippingapproveManifestCollector")
public class ManifestCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestCollector.class);
    private static String cachedCatalog;
    private final ChannelCollector channelCollector;

    public ManifestCollector(ChannelCollector channelCollector) {
        this.channelCollector = channelCollector;
    }

    public void assemble(String value) {
        LOG.debug("开始整理发运字段");
        StringBuilder channelTag1Buffer = new StringBuilder("ref_");
        channelTag1Buffer.append(value);
        String channelTag1 = channelTag1Buffer.toString();
        List<String> catalogKey2Attrs = new ArrayList<String>();
        catalogKey2Attrs.add("web");
        catalogKey2Attrs.add(channelTag1);
        String catalogKey2 = catalogKey2Attrs.get(1);
        cachedCatalog = catalogKey2;
        enrich();
    }

    private void enrich() {
        String receiptKey3 = cachedCatalog;
        String accountRef4 = new StringBuilder(receiptKey3).toString();
        cachedCatalog = accountRef4;
        prepare();
    }

    private void prepare() {
        String voucherRef5 = cachedCatalog;
        String paymentTag6 = new StringBuilder(voucherRef5).toString();
        this.channelCollector.refine(paymentTag6);
    }
}
