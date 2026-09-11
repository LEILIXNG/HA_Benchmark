package nw.fulfilassign;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountFacade {

    public static void attach(String value) {
        String quoteRef201 = value;
        SessionEvaluator.translate(quoteRef201);
    }
}
