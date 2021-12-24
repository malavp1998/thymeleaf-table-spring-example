package app.taxcalculator;

import app.taxcalculator.model.Data;
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
	DataServiceImpl dataServiceImpl;

	@Override
	public void run(String... args) throws Exception {
	//	DataServiceImpl dataServiceImpl = new DataServiceImpl();// By doing this I was not getting data in output when I was calling using controller

		// Reading data from json file and storing it into the dataArrayList
		try
		{
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("/Users/rmalav/IdeaProjects/taxcalculator/data.json");
			Object obj = jsonParser.parse(reader);

			JSONObject dataObj = (JSONObject)obj;

			JSONArray jsonArray = (JSONArray) dataObj.get("invoices");

			System.out.println(jsonArray);
			ArrayList<Data>  dataList = new ArrayList<>();
			for(int i=0; i<jsonArray.size(); i++)
			{
				JSONObject innerObj = (JSONObject) jsonArray.get(i);
				Data data = new Data(Integer.parseInt(innerObj.get("sno").toString()),Integer.parseInt(innerObj.get("amount").toString()),Integer.parseInt(innerObj.get("item_type").toString()));
				dataList.add(data);
			}
			/*Data data1 = new Data(10,100,10,true);
			Data data2 = new Data(11,12100,10,false);
			Data data3 = new Data(12,1100,10,true);
			dataList.add(data1);
			dataList.add(data2);
			dataList.add(data3);*/
			dataServiceImpl.readDatafromJsonFile(dataList);

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
