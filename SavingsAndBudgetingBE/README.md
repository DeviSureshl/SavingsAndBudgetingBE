# SavingsAndBudgetingBE

### This is the backend application for Savings, Accounts and transaction details for a customer

#### Key technologies used

- Spring boot 3.4.5 with JDBC (jdbcTemplate) for data access
- Java 17
- PostgreSQL

### The folder structure of the application is as follows:

- controller
  - AccountsController
  - SavingsAccountsController
  - SavingsAccountTransactionsController
  - TransactionController
  - UserController
- model
  - Accounts
  - SavingsAccounts
  - SavingsAccountTransaction
  - Transaction
  - User
- repository
  - AccountsRepo
  - SavingsAccountsRepo
  - SavingsAccountTransactionsRepo
  - TransactionRepo
  - UserRepo
- dto
  - ApiResponse
- service
  - AccountsService
  - SavingsAccountsService
  - SavingsAccountTransactionsService
  - TransactionService
  - UserService
- exceptions
  - InsufficientBalanceException
  - UserNotFoundException
- utils
  - AccountNumberGenerator

### Keynotes of implementation

- All the rest end points are defined inside the respective Controller classes, all the functional implementations are defined in the Service classes and the queries are executed from the Repository classes using JdbcTemplate.

- Api response formats are defined inside the ApiResponse class.

- All the data models are defined inside the model folder.
