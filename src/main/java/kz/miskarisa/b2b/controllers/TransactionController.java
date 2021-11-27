package kz.miskarisa.b2b.controllers;

import kz.miskarisa.b2b.entities.F_Transaction;
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
            String name = companyRepository.getById(f.getCompanyRecieverId()).getName();
            arr.put("company_name", name);
            newMap.add(arr);
        }

        return new MappingJacksonValue(newMap);
    }


}
