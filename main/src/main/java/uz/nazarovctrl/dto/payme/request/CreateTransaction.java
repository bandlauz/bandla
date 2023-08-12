package uz.nazarovctrl.dto.payme.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateTransaction {
    private String id;
    private long time;
    private Long amount;
    private Account account;
}
