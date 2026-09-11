package nw.customersettlequeue;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("customersettlequeueLedgerCoordinator")
public class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);
    private String pendingRefund;
    private final ContractScreen contractScreen;

    public LedgerCoordinator(ContractScreen contractScreen) {
        this.contractScreen = contractScreen;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次客户处理请求");
        this.submit(value);
    }

    private void submit(String value) {
        final String batchTag1 = value;
        this.pendingRefund = batchTag1;
        prepare();
    }

    private void prepare() {
        String orderRef2 = this.pendingRefund;
        Map<String, String> quoteRef3Attrs = new LinkedHashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("note", orderRef2);
        String quoteRef3 = quoteRef3Attrs.getOrDefault("note", "");
        this.contractScreen.normalize(quoteRef3);
    }
}
