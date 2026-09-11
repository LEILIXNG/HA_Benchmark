package nw.fulfilapprove;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilapproveOrderValidator")
public class OrderValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final ShipmentRouter shipmentRouter;

    public OrderValidator(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.shipmentRouter.enrich(value);
    }
}
