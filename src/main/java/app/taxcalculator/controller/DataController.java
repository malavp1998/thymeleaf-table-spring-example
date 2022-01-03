package app.taxcalculator.controller;

import app.taxcalculator.model.Data;
import app.taxcalculator.service.DataService;
import app.taxcalculator.service.impl.DataServiceArrayListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DataController {


    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String showhHomePage(Model model) {
        //dataService.getData()
        model.addAttribute("dataList", dataService.getDataList());
        model.addAttribute("showbutton", true);
        return "table";
    }


    @GetMapping("/calculateTax/{sno}")
    public String calculateTax(@PathVariable(value = "sno") int s_no) {
        for (int i = 0; i < dataService.getDataList().size(); i++) {
            if (dataService.getDataList().get(i).getS_no() == s_no) {
                Data data = dataService.getDataList().get(i);
                double tax = 0;
                if (data.getItem_type() == 0) {
                    tax = ((double) data.getAmount() * 5) / (double) 100;
                } else if (data.getItem_type() == 1) {
                    tax = ((double) data.getAmount() * 8) / (double) 100;
                } else if (data.getItem_type() == 2) {
                    tax = ((double) data.getAmount() * 12) / (double) 100;
                } else {
                    tax = -1;
                }
                data.setTax(tax);
                data.setTaxCalculate(true);
                dataService.getDataList().set(i, data);
                break;
            }
        }
        return "redirect:/";
    }

}
