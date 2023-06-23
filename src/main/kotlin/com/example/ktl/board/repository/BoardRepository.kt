package com.example.ktl.board.repository

import com.example.ktl.board.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {
}