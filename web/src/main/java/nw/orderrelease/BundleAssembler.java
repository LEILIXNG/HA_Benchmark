package nw.orderrelease;

import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("orderreleaseBundleAssembler")
public class BundleAssembler {
    private final ContractNormalizer contractNormalizer;

    public BundleAssembler(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    public void forward(String value) {
        String batchTag101 = String.format("ref_%s", value);
        this.contractNormalizer.resolve(batchTag101);
    }
}
