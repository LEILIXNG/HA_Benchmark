package nw.accountreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountreconcileShipmentAdapter")
public class ShipmentAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAdapter.class);
    private final TariffPolicySelector tariffPolicySelector;

    public ShipmentAdapter(TariffPolicySelector tariffPolicySelector) {
        this.tariffPolicySelector = tariffPolicySelector;
    }

    public void collect(String value) {
        LOG.debug("开始整理账户字段");
        String accountRef1 = "ref_".concat(value);
        String voucherRef2 = String.valueOf(accountRef1);
        this.tariffPolicySelector.resolve(voucherRef2);
    }
}
