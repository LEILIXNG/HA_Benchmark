package nw.accountbind;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountbindVoucherAdapter")
public class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private final LedgerNormalizer ledgerNormalizer;

    public VoucherAdapter(LedgerNormalizer ledgerNormalizer) {
        this.ledgerNormalizer = ledgerNormalizer;
    }

    public void publish(String value) {
        LOG.trace("进入账户处理环节");
        List<String> tariffRef1Attrs = new ArrayList<String>();
        tariffRef1Attrs.add("web");
        tariffRef1Attrs.add(value);
        String tariffRef1 = tariffRef1Attrs.get(1);
        final String ledgerEntry2 = tariffRef1;
        this.ledgerNormalizer.register(ledgerEntry2);
    }
}
