package com.example.parse_xml.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface ServiceHouseType {
   String parseHouseType(File file) throws ParserConfigurationException, SAXException, IOException;
}
