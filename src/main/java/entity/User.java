package entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    private long id;
    private String name;
    private String lastName;
    private List<Tariff> tariffList;



}
