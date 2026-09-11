package nw.billingquote;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingquoteContractNormalizer")
public class ContractNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractNormalizer.class);
    private String pendingSession;
    private final SessionExecutor sessionExecutor;

    public ContractNormalizer(SessionExecutor sessionExecutor) {
        this.sessionExecutor = sessionExecutor;
    }

    public void refine(String value) {
        LOG.debug("开始整理账务字段");
        this.stage(value);
    }

    private void stage(String value) {
        String refundCode1 = value;
        this.pendingSession = refundCode1;
        enrich();
    }

    private void enrich() {
        String shipmentCode2 = this.pendingSession;
        Map<String, String> manifestKey3Attrs = new LinkedHashMap<String, String>();
        manifestKey3Attrs.put("channel", "web");
        manifestKey3Attrs.put("note", shipmentCode2);
        String manifestKey3 = manifestKey3Attrs.getOrDefault("note", "");
        this.sessionExecutor.route(manifestKey3);
    }
}
