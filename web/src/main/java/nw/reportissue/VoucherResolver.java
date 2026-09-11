package nw.reportissue;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("reportissueVoucherResolver")
public class VoucherResolver {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherResolver.class);
    private final AccountService accountService;

    public VoucherResolver(AccountService accountService) {
        this.accountService = accountService;
    }

    public void stage(String value) {
        LOG.debug("报表流程转下一环节");
        List<String> accountRef201Attrs = new ArrayList<String>();
        accountRef201Attrs.add("web");
        accountRef201Attrs.add(value);
        String accountRef201 = accountRef201Attrs.get(1);
        String voucherRef202 = accountRef201;
        this.accountService.submit(voucherRef202);
    }
}
