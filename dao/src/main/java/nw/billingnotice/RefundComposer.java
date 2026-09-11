package nw.billingnotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundComposer {
    private static final Logger LOG = LoggerFactory.getLogger(RefundComposer.class);

    public static void register(String value) {
        LOG.debug("开始整理账务字段");
        StringBuilder channelTag301Buffer = new StringBuilder("ref_");
        channelTag301Buffer.append(value);
        String channelTag301 = channelTag301Buffer.toString();
        ChannelValidator.compose(channelTag301);
    }
}
