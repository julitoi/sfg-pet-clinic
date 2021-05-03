package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("King");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Viviane");
        owner1.setLastName("Kingston");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner1.setId(3L);
        owner1.setFirstName("Otto");
        owner1.setLastName("Klitschko");

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Patricia");
        vet1.setLastName("Olsen");

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Sandra");
        vet1.setLastName("Wilson");

        System.out.println("Loaded Vets...");
    }
}
