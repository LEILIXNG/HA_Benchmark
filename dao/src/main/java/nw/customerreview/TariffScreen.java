package nw.customerreview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("customerreviewTariffScreen")
public class TariffScreen {
    private static final Logger LOG = LoggerFactory.getLogger(TariffScreen.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final RefundRepository refundRepository;

    public TariffScreen(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }

    public void expand(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.refundRepository.stage(value);
    }
}
