package com.kukot.springjpaoptimization.repository

import com.kukot.springjpaoptimization.persistence.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Long> {
}