export interface AccountDetails {
  balance:                 number;
  accountId:               string;
  currentPage:             number;
  totalPages:              number;
  pageSize:                number;
  accountOperationDTOList: AccountOperation[];
}

export interface AccountOperation {
  id:            number;
  operationDate: Date;
  description:   string;
  amount:        number;
  type:          string;
}
