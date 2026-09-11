package nw.reportposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("reportpostingRefundCoordinator")
public class RefundCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(RefundCoordinator.class);
    private final ManifestRepository manifestRepository;

    public RefundCoordinator(ManifestRepository manifestRepository) {
        this.manifestRepository = manifestRepository;
    }

    public void route(String value) {
        LOG.debug("开始整理报表字段");
        StringBuilder quoteRef401Buffer = new StringBuilder("ref_");
        quoteRef401Buffer.append(value);
        String quoteRef401 = quoteRef401Buffer.toString();
        this.manifestRepository.submit(quoteRef401);
    }
}
