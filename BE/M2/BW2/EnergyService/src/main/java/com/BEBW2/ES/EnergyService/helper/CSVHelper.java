package com.BEBW2.ES.EnergyService.helper;

import com.BEBW2.ES.EnergyService.Entities.Provincia;
import com.BEBW2.ES.EnergyService.Services.ProvinciaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    @Autowired
    ProvinciaService ps;

    public static List<Provincia> csvToProvincie(String path) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream((path))));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Provincia> province = new ArrayList<Provincia>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                String[] s = csvRecord.get(0).split(";");

                Provincia provincia = new Provincia(s[0], s[1], s[2]);

                province.add(provincia);
            }

            System.out.println("=> " + province);

            return province;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static Iterable<CSVRecord> csvToComuni(String path) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream((path))));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            return csvParser.getRecords();

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}

