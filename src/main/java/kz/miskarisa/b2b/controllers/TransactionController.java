package kz.miskarisa.b2b.controllers;

import kz.miskarisa.b2b.entities.Company;
import kz.miskarisa.b2b.entities.F_Transaction;
import kz.miskarisa.b2b.entities.Status;
import kz.miskarisa.b2b.repositories.CompanyRepository;
import kz.miskarisa.b2b.repositories.F_TransactionRepository;
import kz.miskarisa.b2b.repositories.L_TransactionRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private F_TransactionRepository f_transactionRepository;
    private CompanyRepository companyRepository;

    public TransactionController(F_TransactionRepository f_transactionRepository, CompanyRepository companyRepository) {
        this.f_transactionRepository = f_transactionRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/all")
    public MappingJacksonValue getAllTransaction(@RequestParam("start")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                 @RequestParam("end")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        List<F_Transaction> transactions = f_transactionRepository.findAllByDateTimeBetween(start,end);
        List<Map<String, Object>> newMap = new ArrayList<>();
        for (F_Transaction f: transactions) {
            Map<String, Object> arr = new HashMap<>();
            arr.put("dateTime", f.getDateTime());
            arr.put("money", f.getMoney());
            newMap.add(arr);
        }

        return new MappingJacksonValue(newMap);
    }

    @GetMapping("/allByMonth")
    public MappingJacksonValue getAllTransactionByMonth(@RequestParam("start")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                        @RequestParam("end")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<F_Transaction> transactions = f_transactionRepository.findAllByDateTimeBetween(start, end);
        List<Map<String, Object>> arr = new ArrayList<>();
        String[] month = new String[]{"January", "February", "March",
                "April","May","June",
                "July","August","September",
                "October", "November", "December" };
        for (int i = 0; i<12; i++){
            Map<String, Object> arr1 = new HashMap<>();
            arr1.put("month", month[i]);
            arr1.put("money", (float) 0);
            arr.add(arr1);
        }


        for (F_Transaction f : transactions) {
            switch (f.getDateTime().getMonth()) {
                case JANUARY:
                    arr.get(0).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case FEBRUARY:
                    arr.get(1).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case MARCH:
                    arr.get(2).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case APRIL:
                    arr.get(3).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case MAY:
                    arr.get(4).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case JUNE:
                    arr.get(5).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case JULY:
                    arr.get(6).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case AUGUST:
                    arr.get(7).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case SEPTEMBER:
                    arr.get(8).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case OCTOBER:
                    arr.get(9).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case NOVEMBER:
                    arr.get(10).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
                case DECEMBER:
                    arr.get(11).put("money", ((Float) arr.get(0).get("money") + f.getMoney()));
                    break;
            }
        }
        return new MappingJacksonValue(arr);
    }
    @GetMapping("/allMoneyByCompanyName")
    public MappingJacksonValue allMoneyByCompanyName(@RequestParam("start")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                     @RequestParam("end")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        List<F_Transaction> transactions = f_transactionRepository.findAllByDateTimeBetween(start,end);
        List<Map<String, Object>> newMap = new ArrayList<>();

        for (F_Transaction f: transactions) {
            Map<String, Object> arr = new HashMap<>();
            arr.put("companyName", companyRepository.getById(f.getCompanyRecieverId()).getName());
            arr.put("money", f.getMoney());
            newMap.add(arr);
        }

        return new MappingJacksonValue(newMap);
    }

    @GetMapping("/transactionList")
    public MappingJacksonValue getStatus() {
        List<Map<String, Object>> listMap = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();
        Long id = 1L;
        for (Company c : companies){
            if(!id.equals(c.getId())) {
                List<F_Transaction> transactionList = f_transactionRepository.findByCompanyIdAndCompanyRecieverId(id, c.getId());
                if (transactionList.size() > 0) {
                    Map<String, Object> arr = new HashMap<>();
                    arr.put("companyName", c.getName());
                    LocalDate localDate = transactionList.get(0).getDateTime();
                    float money = transactionList.get(0).getMoney();
                    Status status = transactionList.get(0).getStatus();

                    for (int i = 1; i < transactionList.size(); i++) {
                        if (localDate.isBefore(transactionList.get(i).getDateTime())) {
                            localDate = transactionList.get(i).getDateTime();
                            money = transactionList.get(i).getMoney();
                            status = transactionList.get(i).getStatus();
                        }
                    }
                    arr.put("transactionDate", localDate);
                    arr.put("money", money);
                    arr.put("status", status);
                    listMap.add(arr);
                }
            }

        }

        return new MappingJacksonValue(listMap);
    }
}
