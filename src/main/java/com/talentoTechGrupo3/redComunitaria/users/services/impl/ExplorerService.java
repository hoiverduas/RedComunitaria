package com.talentoTechGrupo3.redComunitaria.users.services.impl;


import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.ResponseExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IExplorerRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IExplorerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplorerService implements IExplorerService {

    private final IExplorerRepository explorerRepository;

    public ExplorerService(IExplorerRepository explorerRepository) {
        this.explorerRepository = explorerRepository;
    }


    @Override
    public ResponseExplorerDTO createExplorer(RequestExplorerDTO requestExplorerDTO) {
        return null;
    }

    @Override
    public List<ResponseExplorerDTO> findAllExplorer() {
        return null;
    }

    @Override
    public ResponseExplorerDTO findExplorerById(Long id) {
        return null;
    }

    @Override
    public ResponseExplorerDTO updateExplorer(RequestExplorerDTO requestExplorerDTO) {
        return null;
    }

    @Override
    public String deleteExplorerById(Long id) {
        return null;
    }
}
