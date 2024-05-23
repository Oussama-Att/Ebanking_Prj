package att.oss.ebankingbackend.Dtos;

import att.oss.ebankingbackend.entities.BankAccount;
import att.oss.ebankingbackend.entities.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private String description;
    private Double amount;
    private OperationType type;
}
