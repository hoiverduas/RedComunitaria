package com.talentoTechGrupo3.redComunitaria.comments.controller;

import com.talentoTechGrupo3.redComunitaria.comments.dto.CommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.comments.services.imp.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
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

}
