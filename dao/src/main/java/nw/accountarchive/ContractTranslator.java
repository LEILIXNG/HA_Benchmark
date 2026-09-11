package nw.accountarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("accountarchiveContractTranslator")
public class ContractTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractTranslator.class);
    private final AccountBuilder accountBuilder;

    public ContractTranslator(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void collect(String value) {
        LOG.debug("接收到一次账户处理请求");
        String accountRef301 = "ref_" + value;
        this.accountBuilder.register(accountRef301);
    }
}
