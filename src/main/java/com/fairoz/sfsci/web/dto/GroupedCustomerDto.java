package com.fairoz.sfsci.web.dto;

import com.fairoz.sfsci.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupedCustomerDto {

    private Tag tag;
    private List<String> customers;

}
