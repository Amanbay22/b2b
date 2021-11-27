package kz.miskarisa.b2b.bootstrap;

import kz.miskarisa.b2b.entities.Card;
import kz.miskarisa.b2b.entities.Permission;
import kz.miskarisa.b2b.entities.Role;
import kz.miskarisa.b2b.entities.Status;
import kz.miskarisa.b2b.repositories.CardRepository;
import kz.miskarisa.b2b.repositories.PermissionsRepository;
import kz.miskarisa.b2b.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }
}
