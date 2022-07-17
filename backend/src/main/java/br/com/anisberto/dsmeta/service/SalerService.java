package br.com.anisberto.dsmeta.service;

import br.com.anisberto.dsmeta.entities.Sale;
import br.com.anisberto.dsmeta.repository.SalerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static java.rmi.server.LogStream.log;

@Service
@Log4j2
public class SalerService {

    @Autowired
    private SalerRepository salerRepository;

    public Page<Sale> getAllSalers(Pageable pageable) {
        return salerRepository.findAll(pageable);
    }

    public Page<Sale> getAllSalers(String minData, String maxData, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minData.equals("") ? today.minusDays(365) : LocalDate.parse(minData);
        LocalDate max = maxData.equals("") ? today : LocalDate.parse(maxData);

        return salerRepository.findAllWithMinAndMaxDate(min, max, pageable);
    }
}
