package com.example.parse_xml.parserSax;

import com.example.parse_xml.model.HouseType;
import org.xml.sax.helpers.DefaultHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SAXHouseTypeHandler extends DefaultHandler {
    private HouseType houseType = null;
    private List<HouseType> houseTypeList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("HOUSETYPE")) {
            houseType = new HouseType();
            houseType.setId(Long.parseLong(attributes.getValue("ID")));
            houseType.setActive(Boolean.parseBoolean(attributes.getValue("ISACTIVE")));
            houseType.setDes_c(attributes.getValue("DESC"));
            houseType.setShortName(attributes.getValue("SHORTNAME"));
            houseType.setName(attributes.getValue("NAME"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                houseType.setUpdateDate(dateFormat.parse(attributes.getValue("UPDATEDATE")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                houseType.setEndDate(dateFormat.parse(attributes.getValue("ENDDATE")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                houseType.setStartDate(dateFormat.parse(attributes.getValue("STARTDATE")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("HOUSETYPE")) {
            houseTypeList.add(houseType);
        }
    }

    public List<HouseType> getHouseTypeList() {
        return houseTypeList;
    }
}

