package app.taxcalculator.service.impl;

import app.taxcalculator.model.Data;
import app.taxcalculator.service.DataService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceMapImpl implements DataService {


    Map<Integer,Data> usersData = new HashMap<>();

    @Override
    public List<Data> getDataList() {
        ArrayList<Data> dataList = new ArrayList<>();
        for(Integer i : usersData.keySet()) {
            dataList.add(usersData.get(i));
        }
        return dataList;
    }

    @Override
    public void readDatafromJsonFile(String file_name) {

        System.out.println("In map file name");
       try{
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("/Users/rmalav/IdeaProjects/taxcalculator/"+file_name);
            Object obj = jsonParser.parse(reader);

            JSONObject dataObj = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) dataObj.get("invoices");

            System.out.println(jsonArray);
            //  ArrayList<Data> dataList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject innerObj = (JSONObject) jsonArray.get(i);
                Data data = new Data(Integer.parseInt(innerObj.get("sno").toString()), Integer.parseInt(innerObj.get("amount").toString()), Integer.parseInt(innerObj.get("item_type").toString()));
                System.out.println(data.getTax()+" "+data.getAmount());
                usersData.put(i, data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
