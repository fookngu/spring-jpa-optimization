package com.kukot.springjpaoptimization.config

import net.toiditimtoi.betterpersistence.HypersistenceOptimizer
import net.toiditimtoi.betterpersistence.core.config.JpaConfig
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