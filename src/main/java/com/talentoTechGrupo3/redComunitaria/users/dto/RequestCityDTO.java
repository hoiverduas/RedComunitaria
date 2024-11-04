package com.talentoTechGrupo3.redComunitaria.users.dto;

import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCityDTO {
    private String nameCity;
    private Long departmentId;
}
