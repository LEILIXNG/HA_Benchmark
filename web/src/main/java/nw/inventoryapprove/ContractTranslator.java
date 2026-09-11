package nw.inventoryapprove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventoryapproveContractTranslator")
public class ContractTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ContractTranslator.class);
    private final OrderRegistry orderRegistry;

    public ContractTranslator(OrderRegistry orderRegistry) {
        this.orderRegistry = orderRegistry;
    }

    public void compose(String value) {
        LOG.debug("开始整理库存字段");
        final String quoteRef201 = value;
        this.orderRegistry.expand(quoteRef201);
    }
}
