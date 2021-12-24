package app.taxcalculator.service.impl;

import app.taxcalculator.model.Data;
import app.taxcalculator.service.DataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    ArrayList<Data> dataArrayList;

    public DataServiceImpl() {
        dataArrayList = new ArrayList<>();
    }

    public void readDatafromJsonFile(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @Override
    public List<Data> getDataList() {
        return dataArrayList;
    }
}
