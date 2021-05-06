package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("King");
        owner1.setAddress("234 Miami Street");
        owner1.setCity("Miami");
        owner1.setTelephone("342034832");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Dolly");
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Viviane");
        owner2.setLastName("Kingston");
        owner2.setAddress("222 Street");
        owner2.setCity("Jakarta");
        owner2.setTelephone("335445772");

        Pet vivCat = new Pet();
        vivCat.setPetType(cat);
        vivCat.setName("Miau");
        vivCat.setOwner(owner2);
        vivCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(vivCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Otto");
        owner3.setLastName("Klitschko");
        owner3.setAddress("11 Street");
        owner3.setCity("Moscow");
        owner3.setTelephone("9999999");

        ownerService.save(owner3);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Patricia");
        vet1.setLastName("Olsen");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sandra");
        vet2.setLastName("Wilson");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
