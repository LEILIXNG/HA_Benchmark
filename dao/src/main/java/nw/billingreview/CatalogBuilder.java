package nw.billingreview;

import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("billingreviewCatalogBuilder")
public class CatalogBuilder {
    private final BundleRouter bundleRouter;

    public CatalogBuilder(BundleRouter bundleRouter) {
        this.bundleRouter = bundleRouter;
    }

    public void merge(String value) {
        final String catalogKey201 = value;
        this.bundleRouter.resolve(catalogKey201);
    }
}
