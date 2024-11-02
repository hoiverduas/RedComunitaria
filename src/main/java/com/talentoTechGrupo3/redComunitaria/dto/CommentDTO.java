package com.talentoTechGrupo3.redComunitaria.dto;

import com.talentoTechGrupo3.redComunitaria.entities.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String content;
    private ReactionType reactionType;
    private Long userId;
    private Long publicationId;
}
