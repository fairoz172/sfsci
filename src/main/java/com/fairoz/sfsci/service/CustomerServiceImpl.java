package com.fairoz.sfsci.service;

import com.fairoz.sfsci.model.Customer;
import com.fairoz.sfsci.model.GroupedCustomer;
import com.fairoz.sfsci.model.Tag;
import com.fairoz.sfsci.repositories.CustomerRepository;
import com.fairoz.sfsci.web.dto.CustomerDto;
import com.fairoz.sfsci.web.dto.CustomerReportDto;
import com.fairoz.sfsci.web.dto.GroupedCustomerDto;
import lombok.Synchronized;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        Page<CustomerDto> customerDtoPage = customers.map(this::customerToCustomerDto);
        return customerDtoPage;
    }

    @Override
    public CustomerReportDto getCustomerReport() {
        CustomerReportDto report = CustomerReportDto.builder()
                .averageTimeToBecomeProspect(customerRepository.avgTimeTakenForProspect())
                .averageTimeToBecomeCustomer(customerRepository.avgTimeTakenForCustomer())
                .build();
        return report;
    }

    @Override
    public List<GroupedCustomerDto> getGroupedCustomer() {
        List<GroupedCustomer> groupedCustomers = customerRepository.getGroupedCustomer();
        Map<String, List<String>> groupCustomerMap = new HashMap<>();
        for(GroupedCustomer customer : groupedCustomers){
            List<String> customerList = groupCustomerMap.get(customer.getTag().toString());
            if(customerList == null){
                customerList = new ArrayList<>();
            }
            customerList.add(customer.getFirstName() + " " + customer.getLastName());
            groupCustomerMap.put(customer.getTag().toString(), customerList);
        }
        List<GroupedCustomerDto> dtoList = new ArrayList<>();
        for(String tag : groupCustomerMap.keySet()){
            GroupedCustomerDto dto = GroupedCustomerDto.builder()
                    .tag(Tag.valueOf(tag))
                    .customers(groupCustomerMap.get(tag))
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Synchronized
    private CustomerDto customerToCustomerDto(Customer customer) {
        CustomerDto customerDto = CustomerDto.builder().firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .customerType(customer.getCustomerType())
                .tag(customer.getTag())
                .customerField1Label(customer.getCustomerField1Label())
                .customerField1Type(customer.getCustomerField1Type())
                .customerField1Value(customer.getCustomerField1Value())
                .customerField2Label(customer.getCustomerField2Label())
                .customerField2Type(customer.getCustomerField2Type())
                .customerField2Value(customer.getCustomerField2Value()).build();
        return customerDto;
    }
}
