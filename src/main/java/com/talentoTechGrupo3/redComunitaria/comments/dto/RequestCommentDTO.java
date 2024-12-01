package com.talentoTechGrupo3.redComunitaria.comments.dto;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommentDTO {

    private String content;
    private Long userId;
    private Long publicationId;
}
