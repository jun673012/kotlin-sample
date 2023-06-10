package com.example.ktl.entity

import jakarta.persistence.*

@Entity
class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(nullable = false)
    var content: String? = null
}