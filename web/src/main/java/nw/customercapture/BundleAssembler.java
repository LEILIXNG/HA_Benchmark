package nw.customercapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customercaptureBundleAssembler")
public class BundleAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAssembler.class);
    private final ContractEnricher contractEnricher;

    public BundleAssembler(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    public void collect(String value) {
        LOG.debug("接收到一次客户处理请求");
        String voucherRef101 = String.format("ref_%s", value);
        this.contractEnricher.forward(voucherRef101);
    }
}
