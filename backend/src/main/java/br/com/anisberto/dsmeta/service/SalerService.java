package br.com.anisberto.dsmeta.service;

import br.com.anisberto.dsmeta.entities.Sale;
import br.com.anisberto.dsmeta.repository.SalerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.rmi.server.LogStream.log;

@Service
@Log4j2
public class SalerService {

    @Autowired
    private SalerRepository salerRepository;

    public Page<Sale> getAllSalers(Pageable pageable) {
        log("Buscando vendedores no servidor com paginação! ");
        return salerRepository.findAll(pageable);
    }
}
