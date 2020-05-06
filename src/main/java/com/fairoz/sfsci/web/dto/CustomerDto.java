package com.fairoz.sfsci.web.dto;

import com.fairoz.sfsci.model.CustomerType;
import com.fairoz.sfsci.model.FieldType;
import com.fairoz.sfsci.model.Tag;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private CustomerType customerType;
    private Tag tag;

    private String customerField1Label;
    private FieldType customerField1Type;
    private String customerField1Value;

    private String customerField2Label;
    private FieldType customerField2Type;
    private String customerField2Value;
}
