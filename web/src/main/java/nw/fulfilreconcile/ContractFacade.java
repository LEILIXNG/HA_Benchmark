package nw.fulfilreconcile;

import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilreconcileContractFacade")
public class ContractFacade {
    private final BundleCoordinator bundleCoordinator;

    public ContractFacade(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void prepare(String value) {
        StringBuilder orderRef1Buffer = new StringBuilder("ref_");
        orderRef1Buffer.append(value);
        String orderRef1 = orderRef1Buffer.toString();
        this.bundleCoordinator.publish(orderRef1);
    }
}
