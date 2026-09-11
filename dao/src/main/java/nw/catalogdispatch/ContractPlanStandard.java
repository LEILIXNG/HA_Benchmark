package nw.catalogdispatch;

import org.springframework.stereotype.Repository;

/**
 * 商品的默认处理策略。
 */
@Repository("catalogdispatchContractPlanStandard")
public class ContractPlanStandard implements ContractPlan {
    private final ManifestAssembler manifestAssembler;

    public ContractPlanStandard(ManifestAssembler manifestAssembler) {
        this.manifestAssembler = manifestAssembler;
    }

    @Override
    public void handle(String value) {
        this.manifestAssembler.merge(value);
    }
}
