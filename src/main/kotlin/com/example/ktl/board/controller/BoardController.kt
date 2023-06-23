package com.example.ktl.board.controller

import com.example.ktl.board.entity.Board
import com.example.ktl.board.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(
        private val boardService: BoardService
) {

    @GetMapping("/boards")
    fun findAllBoards(): ResponseEntity<List<Board>> {
        return ResponseEntity.ok(boardService.findAll())
    }

    @GetMapping("/boards/{id}")
    fun findBoard(@PathVariable id: Long): ResponseEntity<Board> {
        return ResponseEntity.ok(boardService.findById(id))
    }

    @PostMapping("/boards")
    fun write(@RequestBody board: Board): ResponseEntity<Board> {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.write(board))
    }

    @PutMapping("/boards/{id}")
    fun edit(@PathVariable id: Long, @RequestBody updateBoard: Board): ResponseEntity<Board> {
        return ResponseEntity.ok(boardService.edit(id, updateBoard))
    }

    @DeleteMapping("/boards/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        boardService.delete(id)
        return ResponseEntity.ok().build()
    }

}