package org.dromara.dynamictp.starter.etcd.autoconfigure;

import com.dtp.common.properties.DtpProperties;
import org.dromara.dynamictp.core.spring.DtpBaseBeanConfiguration;
import org.dromara.dynamictp.starter.etcd.refresh.EtcdRefresher;
import io.etcd.jetcd.Client;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Redick01
 */
@Configuration
@ConditionalOnClass(value = Client.class)
@ConditionalOnBean({DtpBaseBeanConfiguration.class})
@AutoConfigureAfter({DtpBaseBeanConfiguration.class})
public class DtpEtcdAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public EtcdRefresher etcdRefresher(DtpProperties dtpProperties) {
        return new EtcdRefresher(dtpProperties);
    }
}
