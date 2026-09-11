package nw.inventoryledger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelEnricher.class);

    public static void assemble(String value) {
        LOG.debug("接收到一次库存处理请求");
        StringBuilder channelTag401Buffer = new StringBuilder("ref_");
        channelTag401Buffer.append(value);
        String channelTag401 = channelTag401Buffer.toString();
        BatchPlanSelector.enrich(channelTag401);
    }
}
