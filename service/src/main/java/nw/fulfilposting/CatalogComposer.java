package nw.fulfilposting;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class CatalogComposer {
    private String pendingReceipt;

    public static void expand(String value) {
        CatalogComposer self = new CatalogComposer();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey201 = "ref_".concat(value);
        this.pendingReceipt = manifestKey201;
        merge();
    }

    private void merge() {
        String invoiceKey202 = this.pendingReceipt;
        String batchTag203 = "ref_".concat(invoiceKey202);
        String orderRef204 = "ref_" + batchTag203;
        this.pendingReceipt = orderRef204;
        forward();
    }

    private void forward() {
        String quoteRef205 = this.pendingReceipt;
        final String tariffRef206 = quoteRef205;
        BundleRegistry.dispatch(tariffRef206);
    }
}
