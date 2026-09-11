package nw.billingsplit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("billingsplitManifestNormalizer")
public class ManifestNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestNormalizer.class);
    private static String cachedChannel;
    private final AccountService accountService;

    public ManifestNormalizer(AccountService accountService) {
        this.accountService = accountService;
    }

    public void attach(String value) {
        LOG.trace("进入账务处理环节");
        List<String> receiptKey101Attrs = new ArrayList<String>();
        receiptKey101Attrs.add("web");
        receiptKey101Attrs.add(value);
        String receiptKey101 = receiptKey101Attrs.get(1);
        String accountRef102 = String.format("ref_%s", receiptKey101);
        cachedChannel = accountRef102;
        assemble();
    }

    private void assemble() {
        String voucherRef103 = cachedChannel;
        String paymentTag104 = "ref_" + voucherRef103;
        this.accountService.register(paymentTag104);
    }
}
