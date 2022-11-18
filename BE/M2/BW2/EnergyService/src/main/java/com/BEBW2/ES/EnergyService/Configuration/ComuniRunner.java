package com.BEBW2.ES.EnergyService.Configuration;

import com.BEBW2.ES.EnergyService.Entities.*;
import com.BEBW2.ES.EnergyService.Services.*;
import com.BEBW2.ES.EnergyService.helper.CSVHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Order(0)
public class ComuniRunner implements CommandLineRunner {

    @Autowired
    private ProvinciaService ps;

    @Autowired
    private ComuneService cs;

    @Override
    public void run(String... args) throws Exception {
        log.info("RUNNER COMUNI START");

        //createTabComuni();

        log.info("RUNNER COMUNI END");
    }

   private void createTabComuni() throws IOException {
        ps.saveAll("src/main/resources/static/asset/province-italiane.csv");

        Iterable<CSVRecord> csvRecords = CSVHelper.csvToComuni("src/main/resources/static/asset/comuni-italiani.csv");

        List<Comune> comuni = new ArrayList<>();

        for (CSVRecord csvRecord : csvRecords) {

            String[] s = csvRecord.get(0).split(";");

            Optional<Provincia> p = ps.getByName(s[3]);

            if (p.isPresent()) {
                Comune c = new Comune(s[2], p.get());
                comuni.add(c);
            } else {
                throw new IOException("IL comune: " + s[2] + " in Provincia di: " + s[3] + " -> not found");
            }
        }

        cs.saveAll(comuni);
    }

}
