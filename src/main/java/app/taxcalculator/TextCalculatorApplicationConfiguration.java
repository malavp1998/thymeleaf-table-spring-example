package app.taxcalculator;

import app.taxcalculator.controller.DataController;
import app.taxcalculator.service.DataService;
import app.taxcalculator.service.impl.DataServiceArrayListImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TextCalculatorApplicationConfiguration {

    private static final String FILE_NAME = "data.json";

    @Bean
     DataService getDataService() {
        final DataService dataService = new DataServiceArrayListImpl();
        dataService.readDatafromJsonFile(FILE_NAME);
        return dataService;
    }

    @Bean
    DataController getDataController()
    {
        return new DataController(getDataService());
    }



}
