package nw.pricingexport;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderFacade {

    public static void refine(String value) {
        StringBuilder quoteRef301Buffer = new StringBuilder("ref_");
        quoteRef301Buffer.append(value);
        String quoteRef301 = quoteRef301Buffer.toString();
        String tariffRef302 = "ref_" + quoteRef301;
        AccountEvaluator.assemble(tariffRef302);
    }
}
