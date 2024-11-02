package com.talentoTechGrupo3.redComunitaria.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    private  ReactionType reactionType;

    @JsonIgnore
    @ManyToOne
    private User users;

    @JsonIgnore
    @ManyToOne
    private Publication publication;

    @OneToMany(mappedBy = "comment")
    private List<Reaction>reactions;
}
