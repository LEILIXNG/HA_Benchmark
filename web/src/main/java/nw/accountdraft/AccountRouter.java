package nw.accountdraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountdraftAccountRouter")
public class AccountRouter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRouter.class);
    private String pendingSession;
    private static String cachedSession;
    private final InvoiceFacade invoiceFacade;

    public AccountRouter(InvoiceFacade invoiceFacade) {
        this.invoiceFacade = invoiceFacade;
    }

    public void normalize(String value) {
        LOG.debug("账户流程转下一环节");
        this.merge(value);
    }

    private void merge(String value) {
        String quoteRef1 = String.valueOf(value);
        List<String> tariffRef2Attrs = new ArrayList<String>();
        tariffRef2Attrs.add("web");
        tariffRef2Attrs.add(quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get(1);
        this.pendingSession = tariffRef2;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry3 = this.pendingSession;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("reference", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("reference");
        cachedSession = channelTag4;
        forward();
    }

    private void forward() {
        String catalogKey5 = cachedSession;
        String receiptKey6 = String.format("ref_%s", catalogKey5);
        Map<String, String> accountRef7Attrs = new LinkedHashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("note", receiptKey6);
        String accountRef7 = accountRef7Attrs.getOrDefault("note", "");
        this.invoiceFacade.forward(accountRef7);
    }
}
