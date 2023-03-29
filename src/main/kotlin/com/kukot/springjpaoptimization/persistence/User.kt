package com.kukot.springjpaoptimization.persistence

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: UUID,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String
)
