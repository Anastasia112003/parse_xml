package com.example.parse_xml.controller;

import com.example.parse_xml.service.HouseTypeServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@RestController
public class HouseTypeController {
    private final HouseTypeServiceImpl houseTypeService;

    public HouseTypeController(@Qualifier("houseTypeServiceImpl") HouseTypeServiceImpl houseTypeService) {
        this.houseTypeService = houseTypeService;

    }

    @PostMapping("/save")
    public void importToDb() {
        File file = new File("AS_ADDHOUSE_TYPES_20230720_68942f69_7bce_42dc_ba6b_fdc1009976fa.XML");
        try {
            houseTypeService.parseHouseType(file);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
