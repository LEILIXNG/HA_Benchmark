package nw.catalogissue;

import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogissueShipmentFacade")
public class ShipmentFacade {
    private final RefundStrategySelector refundStrategySelector;

    public ShipmentFacade(RefundStrategySelector refundStrategySelector) {
        this.refundStrategySelector = refundStrategySelector;
    }

    public void route(String value) {
        String paymentTag1 = new StringBuilder(value).toString();
        this.refundStrategySelector.enrich(paymentTag1);
    }
}
