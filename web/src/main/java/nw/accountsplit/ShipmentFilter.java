package nw.accountsplit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountsplitShipmentFilter")
public class ShipmentFilter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentFilter.class);
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));
    private final ShipmentExecutor shipmentExecutor;

    public ShipmentFilter(ShipmentExecutor shipmentExecutor) {
        this.shipmentExecutor = shipmentExecutor;
    }

    public void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new ValidationException("command not allowed");
        }
        this.shipmentExecutor.dispatch(value);
    }
}
