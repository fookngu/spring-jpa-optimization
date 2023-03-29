package com.kukot.springjpaoptimization.performance

import io.hypersistence.optimizer.HypersistenceOptimizer
import io.hypersistence.optimizer.core.config.JpaConfig
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.persistence.EntityManagerFactory

@ExtendWith(SpringExtension::class)
@DataJpaTest
class HypersistenceOptimizerTest {

    @Autowired
    private lateinit var hypersistenceOptimizer: HypersistenceOptimizer

    @TestConfiguration
    class HypersistenceConfiguration {

        @Bean
        fun hypersistenceOptimizer(entityManagerFactory: EntityManagerFactory): HypersistenceOptimizer {
            return HypersistenceOptimizer(
                JpaConfig(entityManagerFactory)
            )
        }
    }
    @Test
    fun noIssueWithJpaConfig() {
        assertTrue(hypersistenceOptimizer.events.isEmpty())
    }
}