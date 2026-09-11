package nw.billingdispatch;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingdispatchOrderCoordinator")
public class OrderCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCoordinator.class);
    private String pendingChannel;
    private static String cachedChannel;
    private final QuoteBroker quoteBroker;

    public OrderCoordinator(QuoteBroker quoteBroker) {
        this.quoteBroker = quoteBroker;
    }

    public void stage(String value) {
        LOG.debug("开始整理账务字段");
        this.translate(value);
    }

    private void translate(String value) {
        String channelTag1 = String.valueOf(value);
        String catalogKey2 = channelTag1;
        cachedChannel = catalogKey2;
        enrich();
    }

    private void enrich() {
        String receiptKey3 = cachedChannel;
        Map<String, String> accountRef4Attrs = new LinkedHashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("reference", receiptKey3);
        String accountRef4 = accountRef4Attrs.getOrDefault("reference", "");
        cachedChannel = accountRef4;
        route();
    }

    private void route() {
        String voucherRef5 = cachedChannel;
        String paymentTag6 = "ref_" + voucherRef5;
        this.pendingChannel = paymentTag6;
        forward();
    }

    private void forward() {
        String refundCode7 = this.pendingChannel;
        String shipmentCode8 = String.valueOf(refundCode7);
        String manifestKey9 = String.format("ref_%s", shipmentCode8);
        cachedChannel = manifestKey9;
        submit();
    }

    private void submit() {
        String invoiceKey10 = cachedChannel;
        Map<String, String> batchTag11Attrs = new LinkedHashMap<String, String>();
        batchTag11Attrs.put("channel", "web");
        batchTag11Attrs.put("note", invoiceKey10);
        String batchTag11 = batchTag11Attrs.getOrDefault("note", "");
        this.quoteBroker.normalize(batchTag11);
    }
}
