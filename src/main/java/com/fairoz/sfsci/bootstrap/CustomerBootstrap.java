package com.fairoz.sfsci.bootstrap;

import com.fairoz.sfsci.model.Customer;
import com.fairoz.sfsci.model.CustomerType;
import com.fairoz.sfsci.model.FieldType;
import com.fairoz.sfsci.model.Tag;
import com.fairoz.sfsci.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerBootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerBootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() == 0){
            loadCustomerData();
        }
    }

    private void loadCustomerData() {
        Customer customer1 = Customer.builder()
                .firstName("John")
                .lastName("Bob")
                .email("john@gmail.com")
                .customerType(CustomerType.CUSTOMER)
                .tag(Tag.PROMOTER)
                .customerField1Label("Pin-code")
                .customerField1Type(FieldType.STRING)
                .customerField1Value("785004")
                .timeTakenForProspect(7l)
                .timeTakenForCustomer(20l)
                .build();
        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .firstName("Steve")
                .lastName("Smith")
                .email("steve@gmail.com")
                .customerType(CustomerType.PROSPECT)
                .tag(Tag.VIP)
                .customerField1Label("Designation")
                .customerField1Type(FieldType.STRING)
                .customerField1Value("CEO")
                .customerField2Label("Business Type")
                .customerField2Type(FieldType.STRING)
                .customerField2Value("Financial Services")
                .timeTakenForProspect(3l)
                .build();
        customerRepository.save(customer2);

        Customer customer3 = Customer.builder()
                .firstName("Brett")
                .lastName("Lee")
                .email("bret@gmail.com")
                .customerType(CustomerType.CUSTOMER)
                .tag(Tag.PROMOTER)
                .customerField1Label("Speciality")
                .customerField1Type(FieldType.STRING)
                .customerField1Value("Bowling")
                .timeTakenForProspect(10l)
                .timeTakenForCustomer(11l)
                .build();
        customerRepository.save(customer3);

        Customer customer4 = Customer.builder()
                .firstName("Ricky")
                .lastName("Ponting")
                .email("ponting@gmail.com")
                .customerType(CustomerType.LEAD)
                .tag(Tag.ORANGE)
                .build();
        customerRepository.save(customer4);

        System.out.println("Number of customers: "+ customerRepository.count());
        System.out.println("Customer data loaded successfully");
    }
}
