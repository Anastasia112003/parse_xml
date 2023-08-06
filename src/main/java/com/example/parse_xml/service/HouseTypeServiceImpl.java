package com.example.parse_xml.service;

import com.example.parse_xml.model.HouseType;
import com.example.parse_xml.parserSax.SAXHouseTypeHandler;
import com.example.parse_xml.repository.HouseTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class HouseTypeServiceImpl implements ServiceHouseType {
    private static final Logger LOGGER = LoggerFactory.getLogger(HouseTypeServiceImpl.class);
    private final HouseTypeRepository houseTypeRepository;

    public HouseTypeServiceImpl(HouseTypeRepository houseTypeRepository) {
        this.houseTypeRepository = houseTypeRepository;
    }

    @Override
    public String parseHouseType(File file) throws ParserConfigurationException, SAXException, IOException {
        if (file.getName().endsWith(".XML") && file.isFile()&& file.getName().contains("AS_ADDHOUSE_TYPES")) {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            SAXHouseTypeHandler houseTypeHandler = new SAXHouseTypeHandler();

            FileInputStream fileInputStream = new FileInputStream(file);
            parser.parse(fileInputStream, houseTypeHandler);
            List<HouseType> houseTypes = houseTypeHandler.getHouseTypeList();
            houseTypeRepository.saveAll(houseTypes);
            LOGGER.info("Parsed file "+houseTypes+ "send! ");
            fileInputStream.close();
        }

        return null;
    }
}







