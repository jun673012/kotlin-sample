package com.example.ktl.board.entity

import jakarta.persistence.*

@Entity
class Board(
    title: String,
    content: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String = title

    @Column(nullable = false)
    var content: String = content
}