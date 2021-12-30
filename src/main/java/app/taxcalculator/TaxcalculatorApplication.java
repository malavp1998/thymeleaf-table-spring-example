package app.taxcalculator;

import app.taxcalculator.model.Data;
import app.taxcalculator.service.DataService;
import app.taxcalculator.service.impl.DataServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class TaxcalculatorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TaxcalculatorApplication.class, args);
    }

    @Autowired
    DataService dataService;

    public TaxcalculatorApplication(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void run(String... args) throws Exception {
        //	DataServiceImpl dataServiceImpl = new DataServiceImpl();// By doing this I was not getting data in output when I was calling using controller
        // Reading data from json file and storing it into the dataArrayList
        String file_name = "data.json";
        dataService.readDatafromJsonFile(file_name);


    }
}
