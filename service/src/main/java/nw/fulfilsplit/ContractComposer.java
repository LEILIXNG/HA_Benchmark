package nw.fulfilsplit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("fulfilsplitContractComposer")
public class ContractComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractComposer.class);
    private final ManifestFacade manifestFacade;

    public ContractComposer(ManifestFacade manifestFacade) {
        this.manifestFacade = manifestFacade;
    }

    public void attach(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> manifestKey101Attrs = new LinkedHashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.getOrDefault("detail", "");
        this.manifestFacade.route(manifestKey101);
    }
}
