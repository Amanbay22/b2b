package kz.miskarisa.b2b.bootstrap;

import kz.miskarisa.b2b.entities.*;
import kz.miskarisa.b2b.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ReasonRepository reasonRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private L_TransactionRepository lTransactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private F_TransactionRepository fTransactionRepository;

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello");
//        Status charge = new Status();
//        charge.setName("CHARGE");
//        Status success = new Status();
//        success.setName("SUCCESS");
//        Status cancel = new Status();
//        cancel.setName("CANCEL");
//        statusRepository.save(charge);
//        statusRepository.save(success);
//        statusRepository.save(cancel);
//
//        Reason success1 = new Reason();
//        success1.setName("SUCCESS");
//        success1.setDescription("");
//        Reason failed = new Reason();
//        failed.setName("FAILED");
//        failed.setDescription("BECAUSE I DECIDED");
//        reasonRepository.save(success1);
//        reasonRepository.save(failed);

//        Company company1 = new Company();
//        company1.setName("RyanGoslingInc");
//        company1.setBin("123456789012");
//        company1.setPhone("+7077562042");
//        company1.setAddress("ul Pushkina 322");
//        companyRepository.save(company1);
//
//        Company company2 = new Company();
//        company2.setName("DeVitoCorp");
//        company2.setBin("210987654321");
//        company2.setPhone("+7077562042");
//        company2.setAddress("ul Pushkina 228");
//        companyRepository.save(company2);

//        Company newCmp = companyRepository.getById(1L);
//        Employee employee1 = new Employee();
//        employee1.setFirstName("Alibek");
//        employee1.setLastName("Mazhikenov");
//        employee1.setPhoneNumber("+78005553535");
//        employee1.setCompany(newCmp);
//        employee1.setRole(Role.SEO);
//        employeeRepository.save(employee1);

//        Employee employee2 = new Employee();
//        employee2.setFirstName("Alexander");
//        employee2.setLastName("Lee");
//        employee2.setPhoneNumber("+78005553553");
//        employee2.setCompany(newCmp);
//        employee2.setRole(Role.MANAGER);
//        employeeRepository.save(employee2);

//        L_Transaction l_transaction = new L_Transaction();
//        Card card = cardRepository.getById(1L);
//        Employee employee = employeeRepository.getById(1L);
//        l_transaction.setCard(card);
//        l_transaction.setEmployee(employee);
//        lTransactionRepository.save(l_transaction);

        Reason reason = reasonRepository.getById(1L);
        Status status = statusRepository.getById(2L);
//        F_Transaction f_transaction = new F_Transaction();
//        f_transaction.setDescription("Sanya jivotnoe");
//        f_transaction.setCurrency("KZT");
//        f_transaction.setMoney(1000.53f);
//        f_transaction.setDateTime(LocalDate.now());
//        f_transaction.setReason(reason);
//        f_transaction.setStatus(status);
//        fTransactionRepository.save(f_transaction);

        float min = 400;
        float max = 100000;
        for (int i = 1; i < 20; i++){
            F_Transaction f_transaction = new F_Transaction();
            f_transaction.setDescription("kek");
            f_transaction.setCurrency("KZT");
            Random random = new Random();
            float ourMoney =  min + random.nextFloat() * (max - min);
            f_transaction.setMoney(ourMoney);
            f_transaction.setDateTime(LocalDate.now());
            f_transaction.setReason(reason);
            f_transaction.setStatus(status);
            fTransactionRepository.save(f_transaction);
        }
    }
}
