package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Tariff {

    private Long id;
    private Long userId;
    private String name;
    private Double balance;
}
