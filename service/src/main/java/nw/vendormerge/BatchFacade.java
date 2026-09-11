package nw.vendormerge;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendormergeBatchFacade")
public class BatchFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BatchFacade.class);
    private final AccountFilter accountFilter;

    public BatchFacade(AccountFilter accountFilter) {
        this.accountFilter = accountFilter;
    }

    public void dispatch(String value) {
        LOG.trace("进入供应商处理环节");
        Map<String, String> paymentTag301Attrs = new LinkedHashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("detail", value);
        String paymentTag301 = paymentTag301Attrs.getOrDefault("detail", "");
        String refundCode302 = "ref_" + paymentTag301;
        this.accountFilter.merge(refundCode302);
    }
}
