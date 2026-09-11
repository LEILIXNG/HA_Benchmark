package nw.vendorlookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorlookupBundleFacade")
public class BundleFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BundleFacade.class);

    public void reconcile(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String refundCode1 = "ref_".concat(value);
        BundleResolver.attach(refundCode1);
    }
}
