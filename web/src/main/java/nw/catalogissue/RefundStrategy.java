package nw.catalogissue;

/** 商品处理策略。按渠道挑一个实现。 */
public interface RefundStrategy {

    void handle(String value);
}
