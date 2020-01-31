package ua.kiev.tinedel.basic.spring.wagerledger.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WagerDto {
    private int playerId;
    private int gameId;
    private int money;
}
