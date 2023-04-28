package org.dromara.dynamictp.starter.zookeeper.autoconfigure;

import org.dromara.dynamictp.common.properties.DtpProperties;
import org.dromara.dynamictp.core.spring.PropertiesBinder;
import org.dromara.dynamictp.starter.zookeeper.util.CuratorUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * ZkConfigEnvironmentProcessor related
 *
 * @author yanhom
 * @since 1.0.4
 **/
public class ZkConfigEnvironmentProcessor implements EnvironmentPostProcessor, Ordered {

    public static final String ZK_PROPERTY_SOURCE_NAME = "dtpZkPropertySource";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        DtpProperties dtpProperties = new DtpProperties();
        PropertiesBinder.bindDtpProperties(environment, dtpProperties);
        Map<Object, Object> properties = CuratorUtil.genPropertiesMap(dtpProperties);
        if (!checkPropertyExist(environment)) {
            createZkPropertySource(environment, properties);
        }
    }

    private boolean checkPropertyExist(ConfigurableEnvironment environment) {
        MutablePropertySources propertySources = environment.getPropertySources();
        return propertySources.stream().anyMatch(p -> ZK_PROPERTY_SOURCE_NAME.equals(p.getName()));
    }

    private void createZkPropertySource(ConfigurableEnvironment environment, Map<Object, Object> properties) {
        MutablePropertySources propertySources = environment.getPropertySources();
        OriginTrackedMapPropertySource zkSource = new OriginTrackedMapPropertySource(ZK_PROPERTY_SOURCE_NAME, properties);
        propertySources.addLast(zkSource);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
