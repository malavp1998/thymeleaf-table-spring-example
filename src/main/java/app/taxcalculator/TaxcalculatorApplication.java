package app.taxcalculator;

import app.taxcalculator.service.DataService;
import app.taxcalculator.service.impl.DataServiceMapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxcalculatorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TaxcalculatorApplication.class, args);
    }


   // @Qualifier("dataServiceMapImpl")

    @Qualifier("dataServiceMapImpl")
    @Autowired
    DataService dataServiceforMapList;

    @Qualifier("dataServiceArrayListImpl")
    @Autowired
    DataService dataServiceforArrayList;

  /*  public TaxcalculatorApplication(@Qualifier("dataServiceMapImpl") DataService dataService) {
        this.dataService = dataService;
    }*/

    @Override
    public void run(String... args) throws Exception {
        //	DataServiceImpl dataServiceImpl = new DataServiceImpl();// By doing this I was not getting data in output when I was calling using controller
        // Reading data from json file and storing it into the dataArrayList
        String file_name = "data.json";
        String file_name1 = "data1.json";


        dataServiceforMapList.readDatafromJsonFile(file_name1);
        dataServiceforArrayList.readDatafromJsonFile(file_name);


    }
}
