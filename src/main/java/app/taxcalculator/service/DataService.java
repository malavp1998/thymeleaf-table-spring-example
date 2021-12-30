package app.taxcalculator.service;

import app.taxcalculator.model.Data;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;


public interface DataService {

     List<Data> getDataList();
     void readDatafromJsonFile(String file_name);
}
