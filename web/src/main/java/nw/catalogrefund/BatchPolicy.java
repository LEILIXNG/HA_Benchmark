package nw.catalogrefund;

/** 商品处理策略。按渠道挑一个实现。 */
public interface BatchPolicy {

    void handle(String value);
}
