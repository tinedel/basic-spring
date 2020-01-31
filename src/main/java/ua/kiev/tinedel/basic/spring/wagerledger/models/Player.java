package ua.kiev.tinedel.basic.spring.wagerledger.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String fullName;
}
