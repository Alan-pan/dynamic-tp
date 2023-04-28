package org.dromara.dynamictp.core.monitor.collector;

import org.dromara.dynamictp.common.entity.ThreadPoolStats;

/**
 * MetricsCollector related
 *
 * @author yanhom
 * @since 1.0.0
 **/
public interface MetricsCollector {

    /**
     * Collect key metrics.
     * @param poolStats ThreadPoolStats instance
     */
    void collect(ThreadPoolStats poolStats);

    /**
     * Collector type.
     * @return collector type
     */
    String type();

    /**
     * Judge collector type.
     * @param type collector type
     * @return true if the collector supports this type, else false
     */
    boolean support(String type);
}
