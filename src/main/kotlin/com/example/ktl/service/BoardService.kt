package com.example.ktl.service

import com.example.ktl.entity.Board
import com.example.ktl.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService (
        private val boardRepository: BoardRepository
){
    @Transactional
    fun findById(id: Long): Board{
        return boardRepository.findById(id).orElseThrow()
    }

    @Transactional
    fun findAll(): List<Board>{
        return boardRepository.findAll()
    }

    @Transactional
    fun write(board: Board): Board{
        return boardRepository.save(board)
    }

    @Transactional
    fun edit(id: Long, updateBoard: Board): Board{
        val board = boardRepository.findById(id).orElseThrow()
        board.title = updateBoard.title
        board.content = updateBoard.content
        return board
    }

    @Transactional
    fun delete(id: Long){
        boardRepository.deleteById(id)
    }

}