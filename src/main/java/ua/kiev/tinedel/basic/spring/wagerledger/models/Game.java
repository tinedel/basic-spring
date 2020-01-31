package ua.kiev.tinedel.basic.spring.wagerledger.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime started;
    private String name;
}
