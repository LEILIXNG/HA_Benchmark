package nw.reportnotice;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportnoticeCatalogRegistry")
public class CatalogRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRegistry.class);
    private final BundleScreen bundleScreen;

    public CatalogRegistry(BundleScreen bundleScreen) {
        this.bundleScreen = bundleScreen;
    }

    public void stage(String value) {
        LOG.debug("接收到一次报表处理请求");
        List<String> channelTag201Attrs = new ArrayList<String>();
        channelTag201Attrs.add("web");
        channelTag201Attrs.add(value);
        String channelTag201 = channelTag201Attrs.get(1);
        this.bundleScreen.route(channelTag201);
    }
}
