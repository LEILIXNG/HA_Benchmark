package nw.reportexport;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportexportManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private final ManifestStrategySelector manifestStrategySelector;

    public ManifestEnricher(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void reconcile(String value) {
        LOG.trace("进入报表处理环节");
        List<String> accountRef1Attrs = new ArrayList<String>();
        accountRef1Attrs.add("web");
        accountRef1Attrs.add(value);
        String accountRef1 = accountRef1Attrs.get(1);
        String voucherRef2 = "ref_" + accountRef1;
        this.manifestStrategySelector.resolve(voucherRef2);
    }
}
