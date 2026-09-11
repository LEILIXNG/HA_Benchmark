package nw.orderrelease;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("orderreleaseInvoiceScreen")
public class InvoiceScreen {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceScreen.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final CatalogFetcher catalogFetcher;

    public InvoiceScreen(CatalogFetcher catalogFetcher) {
        this.catalogFetcher = catalogFetcher;
    }

    public void forward(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        this.catalogFetcher.resolve(value);
    }
}
