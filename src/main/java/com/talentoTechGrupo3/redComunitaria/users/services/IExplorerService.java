package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.ResponseExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Explorer;

import java.util.List;

public interface IExplorerService {

    ResponseExplorerDTO createExplorer(RequestExplorerDTO requestExplorerDTO);
    List<ResponseExplorerDTO> findAllExplorer();
    ResponseExplorerDTO findExplorerById(Long id);
    ResponseExplorerDTO updateExplorer(RequestExplorerDTO requestExplorerDTO);
    String deleteExplorerById(Long id);

}
