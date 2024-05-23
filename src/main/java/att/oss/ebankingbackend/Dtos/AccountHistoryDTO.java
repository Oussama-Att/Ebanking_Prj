package att.oss.ebankingbackend.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class AccountHistoryDTO {
    private double balance;
    private String accountId;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<AccountOperationDTO> accountOperationDTOList;

}
