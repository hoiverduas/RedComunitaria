package com.talentoTechGrupo3.redComunitaria.reactions.controller;


import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.reactions.services.impl.ReactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{userId}")
    public ResponseEntity<List<Reaction>> findByReactionByUser(@PathVariable Long userId){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.reactionService.findByReactionByUser(userId));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id){
       try {
           this.reactionService.deleteReaction(id);
           return ResponseEntity
                   .status(HttpStatus.CREATED).build();
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }

}
