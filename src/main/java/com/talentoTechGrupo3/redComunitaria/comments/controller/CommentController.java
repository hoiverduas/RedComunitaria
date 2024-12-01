package com.talentoTechGrupo3.redComunitaria.comments.controller;

import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.comments.services.imp.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody RequestCommentDTO commentDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.commentService.createEntrepreneurComment(commentDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComment(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.commentService.findAllComment());
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.commentService.findByComment(id));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommentById( @PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.commentService.deleteCommentById(id));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

}
