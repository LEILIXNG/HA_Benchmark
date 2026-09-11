package nw.vendorsync;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundService {
    private static final Logger LOG = LoggerFactory.getLogger(RefundService.class);

    public static void dispatch(String value) {
        LOG.debug("供应商流程转下一环节");
        String accountRef201 = String.valueOf(value);
        List<String> voucherRef202Attrs = new ArrayList<String>();
        voucherRef202Attrs.add("web");
        voucherRef202Attrs.add(accountRef201);
        String voucherRef202 = voucherRef202Attrs.get(1);
        AccountPolicySelector.reconcile(voucherRef202);
    }
}
