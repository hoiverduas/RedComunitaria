package com.talentoTechGrupo3.redComunitaria.controller;


import com.talentoTechGrupo3.redComunitaria.dto.ReactionCommentDTO;
import com.talentoTechGrupo3.redComunitaria.dto.ReactionPublicationDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.services.impl.ReactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping("/publication")
    public ResponseEntity<Reaction> createReactionPublication(@RequestParam ReactionType reactionType,
                                                              @RequestParam Long userId,
                                                              @RequestParam Long publicationId ){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reactionService.createReactionPublication(userId,publicationId,reactionType));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @PostMapping("/comment")
    public ResponseEntity<Reaction> createReactionComment(@RequestParam Long userId,
                                                          @RequestParam Long commentId,
                                                          @RequestParam ReactionType reactionType){

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reactionService.createReactionComment(userId,commentId,reactionType));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }
}
