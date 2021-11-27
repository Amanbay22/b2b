package kz.miskarisa.b2b.controllers;

import kz.miskarisa.b2b.entities.F_Transaction;
import kz.miskarisa.b2b.repositories.F_TransactionRepository;
import kz.miskarisa.b2b.repositories.L_TransactionRepository;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private F_TransactionRepository f_transactionRepository;
    private L_TransactionRepository l_transactionRepository;

    public TransactionController(F_TransactionRepository f_transactionRepository, L_TransactionRepository l_transactionRepository) {
        this.f_transactionRepository = f_transactionRepository;
        this.l_transactionRepository = l_transactionRepository;
    }

    @GetMapping("/all")
    public MappingJacksonValue getAllTransaction() {

        List<F_Transaction> transactions = f_transactionRepository.findAll();

        MappingJacksonValue jsonT = new MappingJacksonValue(transactions);

        return jsonT;
    }



}
