package com.example.parse_xml.service;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.io.*;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HouseTypeServiceImplTest {


    @Test
    void parseHouseType() throws SAXException, IOException, ParserConfigurationException {
        HouseTypeServiceImpl dictMock = mock(HouseTypeServiceImpl.class);
        doThrow(IllegalStateException.class).when(dictMock)
                .parseHouseType(null);
        assertThrows(IllegalStateException.class, () -> dictMock.parseHouseType(null));
    }


}

