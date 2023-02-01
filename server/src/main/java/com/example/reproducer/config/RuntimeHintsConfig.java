package com.example.reproducer.config;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints(RuntimeHintsConfig.ArxRuntimeHintsRegistrar.class)
public class RuntimeHintsConfig {

    static class ArxRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            try {
                hints.reflection().registerTypeIfPresent(classLoader,
                        "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl",
                        MemberCategory.values());
                hints.reflection().registerTypeIfPresent(classLoader, "org.hibernate.dialect.H2Dialect",
                        MemberCategory.values());
                hints.reflection().registerTypeIfPresent(classLoader, "com.arx.common.model.Bean",
                        MemberCategory.values());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
