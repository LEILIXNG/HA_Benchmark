package nw.accountrollup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountrollupBundleAdapter")
public class BundleAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAdapter.class);
    private static String cachedContract;

    public void submit(String value) {
        LOG.debug("账户流程转下一环节");
        List<String> invoiceKey101Attrs = new ArrayList<String>();
        invoiceKey101Attrs.add("web");
        invoiceKey101Attrs.add(value);
        String invoiceKey101 = invoiceKey101Attrs.get(1);
        Map<String, String> batchTag102Attrs = new LinkedHashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.getOrDefault("remark", "");
        cachedContract = batchTag102;
        stage();
    }

    private void stage() {
        String orderRef103 = cachedContract;
        String quoteRef104 = String.valueOf(orderRef103);
        cachedContract = quoteRef104;
        register();
    }

    private void register() {
        String tariffRef105 = cachedContract;
        Map<String, String> ledgerEntry106Attrs = new LinkedHashMap<String, String>();
        ledgerEntry106Attrs.put("channel", "web");
        ledgerEntry106Attrs.put("remark", tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.getOrDefault("remark", "");
        String channelTag107 = ledgerEntry106;
        ContractEvaluator.collect(channelTag107);
    }
}
