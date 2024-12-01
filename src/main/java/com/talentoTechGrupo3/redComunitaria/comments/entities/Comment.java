package com.talentoTechGrupo3.redComunitaria.comments.entities;


import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.CommentReaction;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationDate;

    private String content;

    @ManyToOne
    private User users;

    @ManyToOne
    private Publication publication;

    @OneToMany(mappedBy = "comment" ,cascade =CascadeType.REMOVE )
    private List<CommentReaction> commentReactions;
}
