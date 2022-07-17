package br.com.anisberto.dsmeta.controller;

import br.com.anisberto.dsmeta.entities.Sale;
import br.com.anisberto.dsmeta.service.SalerService;
import br.com.anisberto.dsmeta.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("saler")
public class SalerController {

    @Autowired
    private SalerService salerService;

    @Autowired
    private SmsService smsService;

    @GetMapping("pageable")
    public ResponseEntity<Page<Sale>> getAllSaler(Pageable pageable) {
        return ResponseEntity.ok(salerService.getAllSalers(pageable));
    }

    @GetMapping
    public ResponseEntity<Page<Sale>> getAllSaler(
            @RequestParam(value = "minData", defaultValue = "") String minData,
            @RequestParam(value = "maxData", defaultValue = "") String maxData,
            Pageable pageable) {
        return ResponseEntity.ok(salerService.getAllSalers(minData, maxData, pageable));
    }

    @GetMapping("{id}/notification")
    public void nofitySaler(@PathVariable("id") Integer id) {
        smsService.sendSms(id);
    }
}
