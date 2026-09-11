package nw.pricingmanifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingmanifestContractBuilder")
public class ContractBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ContractBuilder.class);
    private final AccountComposer accountComposer;

    public ContractBuilder(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    public void publish(String value) {
        LOG.debug("接收到一次定价处理请求");
        String refundCode101 = "ref_" + value;
        String shipmentCode102 = new StringBuilder(refundCode101).toString();
        this.accountComposer.compose(shipmentCode102);
    }
}
