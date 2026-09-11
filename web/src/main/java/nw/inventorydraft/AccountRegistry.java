package nw.inventorydraft;

import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorydraftAccountRegistry")
public class AccountRegistry {
    private final ChannelPolicySelector channelPolicySelector;

    public AccountRegistry(ChannelPolicySelector channelPolicySelector) {
        this.channelPolicySelector = channelPolicySelector;
    }

    public void submit(String value) {
        String shipmentCode1 = new StringBuilder(value).toString();
        String manifestKey2 = "ref_".concat(shipmentCode1);
        this.channelPolicySelector.route(manifestKey2);
    }
}
