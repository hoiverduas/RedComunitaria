package com.talentoTechGrupo3.redComunitaria.reactions.controller;


import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.RequestCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.ResponseCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.services.impl.CommentReactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commentReaction")
public class CommentReactionController {

    private final CommentReactionService commentReactionService;

    public CommentReactionController(CommentReactionService commentReactionService) {
        this.commentReactionService = commentReactionService;
    }

    @PostMapping
    public ResponseEntity<ResponseCommentReactionDTO> createCommentReaction(RequestCommentReactionDTO requestCommentReactionDTO){
       try {
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(this.commentReactionService.createReactionComment(requestCommentReactionDTO));
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }


}
