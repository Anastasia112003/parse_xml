package com.example.parse_xml;

import com.example.parse_xml.comand.MainRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;


@SpringBootApplication
public class ParseXmlApplication implements CommandLineRunner, ExitCodeGenerator {
    private CommandLine.IFactory factory;
    private MainRunner mainRunner;
    private int exitCode;

    ParseXmlApplication(CommandLine.IFactory factory, MainRunner mainRunner) {
        this.factory = factory;
        this.mainRunner = mainRunner;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(ParseXmlApplication.class, args)));
    }


    @Override
    public void run(String... args) {
        exitCode = new CommandLine(mainRunner, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
