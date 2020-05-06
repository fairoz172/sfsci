package com.fairoz.sfsci.web.controllers;

import com.fairoz.sfsci.service.CustomerService;
import com.fairoz.sfsci.web.dto.CustomerDto;
import com.fairoz.sfsci.web.dto.CustomerReportDto;
import com.fairoz.sfsci.web.dto.GroupedCustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public Page<CustomerDto> getCustomers(Pageable pageable){
        return customerService.getCustomers(pageable);
    }

    @GetMapping("/report")
    public CustomerReportDto getCustomerReport(){
        return customerService.getCustomerReport();
    }

    @GetMapping("/grouped")
    public List<GroupedCustomerDto> getGroupedCustomer(){
        return customerService.getGroupedCustomer();
    }

}
