package com.kukot.springjpaoptimization.startup

import com.kukot.springjpaoptimization.repository.UsersRepository
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

@Component
class StartupCounter(
       val userRepository: UsersRepository,
        val transactionManager: PlatformTransactionManager
): ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
//        countByTransactionTemplate()
        countByRepositoryWithoutTransactionDeclaration()
    }

    private fun countByRepositoryWithoutTransactionDeclaration() {
        val noOfUser = userRepository.findAll().size
        print("There are $noOfUser in this database")
    }
    private fun countByTransactionTemplate() {
        TransactionTemplate(transactionManager).execute {
            val totalUsers = userRepository.findAll().size
            println("There are $totalUsers in this database\n")
        }
    }
}