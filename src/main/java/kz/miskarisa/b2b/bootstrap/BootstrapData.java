package kz.miskarisa.b2b.bootstrap;

import kz.miskarisa.b2b.entities.Status;
import kz.miskarisa.b2b.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;

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
    }
}
