package com.talentoTechGrupo3.redComunitaria.comments.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateCommentDTO {

    private Long id;
    private String content;
    private Long userId;
    private Long publicationId;

}
