package nw.pricingrevise;

import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingreviseReceiptPolicy")
public class ReceiptPolicy {
    private final CatalogLoader catalogLoader;

    public ReceiptPolicy(CatalogLoader catalogLoader) {
        this.catalogLoader = catalogLoader;
    }

    public void attach(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.replace("../", "");
        this.catalogLoader.refine(cleaned);
    }
}
