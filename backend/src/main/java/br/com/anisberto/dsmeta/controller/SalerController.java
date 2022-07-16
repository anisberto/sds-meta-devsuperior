package br.com.anisberto.dsmeta.controller;

import br.com.anisberto.dsmeta.entities.Sale;
import br.com.anisberto.dsmeta.service.SalerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("saler")
public class SalerController {

    @Autowired
    private SalerService salerService;

    @GetMapping
    public ResponseEntity<Page<Sale>> getAllSaler(Pageable pageable){
        return ResponseEntity.ok(salerService.getAllSalers(pageable));
    }
}
