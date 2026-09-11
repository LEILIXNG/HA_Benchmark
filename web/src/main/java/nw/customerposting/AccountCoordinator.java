package nw.customerposting;

/**
 * 客户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountCoordinator {

    public static void reconcile(String value) {
        String catalogKey1 = String.valueOf(value);
        String receiptKey2 = "ref_".concat(catalogKey1);
        VoucherAdapter.forward(receiptKey2);
    }
}
