package org.dromara.dynamictp.starter.cloud.consul.autoconfigure;

import com.dtp.common.properties.DtpProperties;
import org.dromara.dynamictp.starter.cloud.consul.refresh.CloudConsulRefresher;
import org.dromara.dynamictp.core.spring.DtpBaseBeanConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.consul.config.ConsulConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Redick01
 */
@Configuration
@ConditionalOnClass(ConsulConfigProperties.class)
@ConditionalOnBean({DtpBaseBeanConfiguration.class})
@AutoConfigureAfter({DtpBaseBeanConfiguration.class})
public class DtpConsulAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean()
    @ConditionalOnProperty(value = "spring.cloud.consul.config.enabled", matchIfMissing = true)
    public CloudConsulRefresher cloudConsulRefresher(DtpProperties dtpProperties) {
        return new CloudConsulRefresher(dtpProperties);
    }
}
