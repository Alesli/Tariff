package com.wwhale.tariff.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Client {

    private long id;
    private String name;
    private String lastName;
}
