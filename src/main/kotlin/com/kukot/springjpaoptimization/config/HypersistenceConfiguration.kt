package com.kukot.springjpaoptimization.config

import io.hypersistence.optimizer.HypersistenceOptimizer
import io.hypersistence.optimizer.core.config.JpaConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class HypersistenceConfiguration {

    @Bean
    fun hypersistenceOptimizer(entityManagerFactory: EntityManagerFactory): HypersistenceOptimizer {
        return HypersistenceOptimizer(
            JpaConfig(entityManagerFactory)
        )
    }
}