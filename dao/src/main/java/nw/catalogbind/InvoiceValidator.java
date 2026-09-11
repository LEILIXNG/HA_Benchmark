package nw.catalogbind;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("catalogbindInvoiceValidator")
public class InvoiceValidator {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceValidator.class);
    private final TariffEvaluator tariffEvaluator;

    public InvoiceValidator(TariffEvaluator tariffEvaluator) {
        this.tariffEvaluator = tariffEvaluator;
    }

    public void attach(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        this.tariffEvaluator.prepare(value);
    }
}
