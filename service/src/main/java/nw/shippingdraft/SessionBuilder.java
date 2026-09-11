package nw.shippingdraft;

import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingdraftSessionBuilder")
public class SessionBuilder {
    private final ChannelComposer channelComposer;

    public SessionBuilder(ChannelComposer channelComposer) {
        this.channelComposer = channelComposer;
    }

    public void attach(String value) {
        String accountRef101 = new StringBuilder(value).toString();
        final String voucherRef102 = accountRef101;
        this.channelComposer.register(voucherRef102);
    }
}
