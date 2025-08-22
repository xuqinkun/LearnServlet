package com.web.servlet.hiddenfields;

import lombok.Data;

@Data
public class Customer {
    private int id;

    private String name;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String zipCode;
}
