package nw.vendorreview;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendorreviewVoucherRegistry")
public class VoucherRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRegistry.class);
    private final TariffNormalizer tariffNormalizer;

    public VoucherRegistry(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次供应商处理请求");
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("detail");
        Map<String, String> channelTag302Attrs = new HashMap<String, String>();
        channelTag302Attrs.put("channel", "web");
        channelTag302Attrs.put("remark", ledgerEntry301);
        String channelTag302 = channelTag302Attrs.get("remark");
        this.tariffNormalizer.submit(channelTag302);
    }
}
