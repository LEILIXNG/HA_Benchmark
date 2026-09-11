package nw.shippingdigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingdigestBundleValidator")
public class BundleValidator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleValidator.class);
    private final LedgerRepository ledgerRepository;

    public BundleValidator(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public void resolve(String value) {
        // 历史单据号里带引号，入库前统一去掉
        String cleaned = value.replaceAll("'", "");
        this.ledgerRepository.dispatch(cleaned);
    }
}
