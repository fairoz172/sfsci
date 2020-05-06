package com.fairoz.sfsci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupedCustomer {

    private Tag tag;
    private String firstName;
    private String lastName;

}
