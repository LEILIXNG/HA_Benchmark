package nw.orderverify;

import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderverifyCatalogScreen")
public class CatalogScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final PaymentGateway paymentGateway;

    public CatalogScreen(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        this.paymentGateway.route(value);
    }
}
