package nw.accountdispatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accountdispatchLedgerCoordinator")
public class LedgerCoordinator {
    private String pendingVoucher;

    public void submit(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        List<String> receiptKey401Attrs = new ArrayList<String>();
        receiptKey401Attrs.add("web");
        receiptKey401Attrs.add(value);
        String receiptKey401 = receiptKey401Attrs.get(1);
        this.pendingVoucher = receiptKey401;
        refine();
    }

    private void refine() {
        String accountRef402 = this.pendingVoucher;
        Map<String, String> voucherRef403Attrs = new HashMap<String, String>();
        voucherRef403Attrs.put("channel", "web");
        voucherRef403Attrs.put("note", accountRef402);
        String voucherRef403 = voucherRef403Attrs.get("note");
        VoucherLoader.assemble(voucherRef403);
    }
}
