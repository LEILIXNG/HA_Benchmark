package nw.reportreconcile;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("reportreconcileRefundCoordinator")
public class RefundCoordinator {
    private final ContractRepository contractRepository;

    public RefundCoordinator(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void normalize(String value) {
        List<String> tariffRef401Attrs = new ArrayList<String>();
        tariffRef401Attrs.add("web");
        tariffRef401Attrs.add(value);
        String tariffRef401 = tariffRef401Attrs.get(1);
        String ledgerEntry402 = String.valueOf(tariffRef401);
        this.contractRepository.submit(ledgerEntry402);
    }
}
