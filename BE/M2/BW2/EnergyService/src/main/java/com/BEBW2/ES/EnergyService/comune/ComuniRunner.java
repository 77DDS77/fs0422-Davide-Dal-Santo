package com.BEBW2.ES.EnergyService.comune;


import com.BEBW2.ES.EnergyService.comune.helper.CSVHelper;
import com.BEBW2.ES.EnergyService.comune.model.Comune;
import com.BEBW2.ES.EnergyService.comune.model.Provincia;
import com.BEBW2.ES.EnergyService.comune.services.ComuneService;
import com.BEBW2.ES.EnergyService.comune.services.ProvinciaService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ComuniRunner implements CommandLineRunner {

    @Autowired
    ProvinciaService ps;

    @Autowired
    ComuneService cs;

    @Override
    public void run(String... args) throws Exception {

        createTabComuni();

    }

    private void createTabComuni() throws IOException{
        ps.saveAll("src/main/resources/comuni-italiani/province-italiane.csv");

        Iterable<CSVRecord> csvRecords = CSVHelper.csvToComuni("src/main/resources/comuni-italiani/comuni-italiani.csv");

        for (CSVRecord csvRecord : csvRecords) {

            String[] s = csvRecord.get(0).split(";");

            Optional<Provincia> p = ps.getByName(s[3]);

            if(p.isPresent()) {
                Comune c = new Comune(s[2], p.get());
                cs.save(c);

            }else{
                throw new IOException("Comune " +s[2] +" in Provincia "+ s[3] +" not found");
            }

        }
    }

}
