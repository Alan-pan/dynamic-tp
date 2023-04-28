package org.dromara.dynamictp.example;

import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fabian4
 */
@EnableDynamicTp
@SpringBootApplication
public class Okhttp3ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Okhttp3ExampleApplication.class, args);
    }
}
