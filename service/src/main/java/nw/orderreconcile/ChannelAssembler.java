package nw.orderreconcile;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderreconcileChannelAssembler")
public class ChannelAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAssembler.class);
    private final ManifestStrategySelector manifestStrategySelector;

    public ChannelAssembler(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void route(String value) {
        LOG.trace("进入订单处理环节");
        final String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new LinkedHashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("remark", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.getOrDefault("remark", "");
        this.manifestStrategySelector.enrich(receiptKey202);
    }
}
