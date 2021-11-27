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
import java.util.*;

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
            String name = companyRepository.getById(f.getCompanyRecieverId()).getName();
            arr.put("company_name", name);
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
                Map<String, Object> arr = new HashMap<>();
//                arr.put("id", c.getId());
                arr.put("companyName", c.getName());
                List<F_Transaction> transactionList = f_transactionRepository.findAllByCompanyIdAndCompanyRecieverId(1L, c.getId());
                if (transactionList.size() > 0) {
                    LocalDate localDate = transactionList.get(0).getDateTime();
                    float money = transactionList.get(0).getMoney();
                    Status status = transactionList.get(0).getStatus();

                    for (int i = 0; i < transactionList.size()-1; i++) {
                        if (transactionList.get(i).getDateTime().compareTo(transactionList.get(i + 1).getDateTime()) > 0) {
                            localDate = transactionList.get(i).getDateTime();
                            money = transactionList.get(i).getMoney();
                            status = transactionList.get(i).getStatus();
                        }
                    }
                    arr.put("transactionDate", localDate);
                    arr.put("money", money);
                    arr.put("status", status);
                }
                listMap.add(arr);
            }

        }

        return new MappingJacksonValue(listMap);
    }

}
