package com.example.parse_xml.comand;

import com.example.parse_xml.service.ServiceHouseType;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;


@Component
@CommandLine.Command(name = "mainRunner")
public class MainRunner implements Callable<String> {
    private final ServiceHouseType serviceHouseType;
    @CommandLine.Option(names = "--file")
    File file = new File("C:\\Users\\Анастасия\\IdeaProjects\\parse_xml");

    public MainRunner(ServiceHouseType serviceHouseType) {
        this.serviceHouseType = serviceHouseType;
    }

    @Override
    public String call() throws Exception {
        return serviceHouseType.parseHouseType(file);

    }


}
