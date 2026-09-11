package nw.reportquote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("reportquotePaymentRegistry")
public class PaymentRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentRegistry.class);
    private final CatalogRepository catalogRepository;

    public PaymentRegistry(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void translate(String value) {
        LOG.debug("开始整理报表字段");
        String orderRef401 = "ref_" + value;
        this.catalogRepository.compose(orderRef401);
    }
}
