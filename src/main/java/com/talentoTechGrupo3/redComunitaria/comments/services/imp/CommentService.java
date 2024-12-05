package com.talentoTechGrupo3.redComunitaria.comments.services.imp;

import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestUpdateCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.dto.ResponseCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.comments.repository.ICommentRepository;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.comments.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService implements ICommentService {

    private final ICommentRepository commentRepository;
    private final IUserRepository userRepository;
    private final IPublicationRepository publicationRepository;

    @Autowired
    public CommentService(ICommentRepository commentRepository, IUserRepository userRepository, IPublicationRepository publicationRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    // Método de mapeo: de RequestCommentDTO a Comment
    private Comment mapToEntity(RequestCommentDTO dto) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        comment.setUsers(user);

        Publication publication = publicationRepository.findById(dto.getPublicationId())
                .orElseThrow(() -> new RuntimeException("Publication not found"));
        comment.setPublication(publication);

        comment.setCreationDate(LocalDateTime.now());
        return comment;
    }

    // Método de mapeo: de Comment a ResponseCommentDTO
    private ResponseCommentDTO mapToDto(Comment comment) {
        return new ResponseCommentDTO(
                comment.getId(),
                comment.getContent(),
                comment.getUsers().getId(),
                comment.getPublication().getId()
        );
    }

    private Comment mapToEntity(RequestUpdateCommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        return comment;
    }


    @Override
    public ResponseCommentDTO createEntrepreneurComment(RequestCommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);
        Comment savedComment = this.commentRepository.save(comment);
        return mapToDto(savedComment);
    }

    @Override
    public List<ResponseCommentDTO> findAllComment() {
        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        return comments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCommentDTO findByComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return mapToDto(comment);
    }

    @Override
    public String deleteCommentById(Long id) {
        findByComment(id); // Asegura que existe antes de eliminarlo
        this.commentRepository.deleteById(id);
        return "Comentario con id: " + id + " fue eliminado exitosamente";
    }

    @Override
    public ResponseCommentDTO updateComment(RequestUpdateCommentDTO commentDTO) {

            // Buscar el comentario existente
            Comment comment = commentRepository.findById(commentDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

            // Actualizar los campos del comentario
            comment.setContent(commentDTO.getContent());

            // Opcional: validar si el usuario y la publicación deben cambiar
            if (commentDTO.getUserId() != null) {
                User user = userRepository.findById(commentDTO.getUserId())
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                comment.setUsers(user);
            }

            if (commentDTO.getPublicationId() != null) {
                Publication publication = publicationRepository.findById(commentDTO.getPublicationId())
                        .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
                comment.setPublication(publication);
            }

            // Guardar los cambios
            Comment updatedComment = commentRepository.save(comment);

            // Mapear a ResponseCommentDTO
            return mapToDto(updatedComment);
        }


}



