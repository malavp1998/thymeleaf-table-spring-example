package app.taxcalculator;

import app.taxcalculator.service.DataService;
import app.taxcalculator.service.impl.DataServiceMapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({TextCalculatorApplicationConfiguration.class})
public class TaxcalculatorApplication {


    public static void main(String[] args) {

        SpringApplication.run(TaxcalculatorApplication.class, args);
    }

/*

    @Qualifier("dataServiceMapImpl")
    @Autowired
    DataService dataServiceforMapList;

    @Qualifier("dataServiceArrayListImpl")
    @Autowired
    DataService dataServiceforArrayList;
    @Override
    public void run(String... args) throws Exception {

        String file_name = "data.json";
        String file_name1 = "data1.json";

        dataServiceforMapList.readDatafromJsonFile(file_name1);
        dataServiceforArrayList.readDatafromJsonFile(file_name);


    }*/

}
