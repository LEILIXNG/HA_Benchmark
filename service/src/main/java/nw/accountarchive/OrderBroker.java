package nw.accountarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountarchiveOrderBroker")
public class OrderBroker {
    private static final Logger LOG = LoggerFactory.getLogger(OrderBroker.class);
    private final ContractTranslator contractTranslator;

    public OrderBroker(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    public void assemble(String value) {
        LOG.debug("接收到一次账户处理请求");
        String manifestKey201 = "ref_".concat(value);
        this.contractTranslator.collect(manifestKey201);
    }
}
