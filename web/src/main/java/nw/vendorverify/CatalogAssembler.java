package nw.vendorverify;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogAssembler.class);

    public static void translate(String value) {
        LOG.debug("供应商流程转下一环节");
        List<String> ledgerEntry1Attrs = new ArrayList<String>();
        ledgerEntry1Attrs.add("web");
        ledgerEntry1Attrs.add(value);
        String ledgerEntry1 = ledgerEntry1Attrs.get(1);
        RefundPolicySelector.reconcile(ledgerEntry1);
    }
}
