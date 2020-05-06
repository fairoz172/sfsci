package com.fairoz.sfsci.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private CustomerType customerType;

    @Enumerated(value = EnumType.STRING)
    private Tag tag;

    private String customerField1Label;
    @Enumerated(value = EnumType.STRING)
    private FieldType customerField1Type;
    private String customerField1Value;

    private String customerField2Label;
    @Enumerated(value = EnumType.STRING)
    private FieldType customerField2Type;
    private String customerField2Value;

    private Long timeTakenForProspect;
    private Long timeTakenForCustomer;

    @CreationTimestamp
    private Timestamp createdTimestamp;

    @UpdateTimestamp
    private Timestamp lastUpdatedTimestamp;
}
