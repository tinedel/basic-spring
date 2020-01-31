package ua.kiev.tinedel.basic.spring.wagerledger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wager {

    @Id
    @GeneratedValue
    private Integer id;

    private Boolean winning;

    private int money;

    @ManyToOne
    private Player player;
    @ManyToOne
    private Game game;

}
