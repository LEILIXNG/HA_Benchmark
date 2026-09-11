package nw.inventorysubmit;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractBuilder {

    public static void dispatch(String value) {
        String manifestKey201 = String.valueOf(value);
        VoucherBroker.collect(manifestKey201);
    }
}
