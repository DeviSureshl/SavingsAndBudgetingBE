# Savings And Budgeting

### This is a banking application for handling Savings, Accounts and transaction details of a customer.

#### You can find the documentation for frontend, backend and database here:

- [Frontend](SavingsAndBudgetingFE/README.md)
- [Backend](SavingsAndBudgetingBE/README.md)
- [Database](DB/README.md)

## Application Pages and Functionalities

### 1. Login screen

The user can login into the application with the email id and password.

![Login screen](screenshots/UserLogin.png?raw=true "Login screen")

### 2. Register User

One can register himself to the application providing personal information (Name, email, date of birth, gender, password).

![Register User](screenshots/RegisterUser.png?raw=true "Register User")

### 3. Admin Dashboard

If the logged in user is an admin, he can view the user list. He can also add, view or delete a user.

![Admin Dashboard](screenshots/AdminDashboard.png?raw=true "Admin Dashboard")

### 4. User Dashboard

Here you can see the account details of the logged in user such as profile info, account summary, savings summary and transaction summary.

![User Dashboard](screenshots/UserDashboard.png?raw=true "User Dashboard")

### 5. Create Account

User can create a new account(Current account or Checking account) and provide an initial deposit.

![Add Account](screenshots/AddAccount.png?raw=true "Add Account")

### 6. Create Savings Account

User can create a savings account for a specific goal. He have to provide the target amount, target date and the goal name. He can also provide an initial deposit.

![Create Savings Account](screenshots/CreateSavingsAccount.png?raw=true "Create Savings Account")

### 7. Savings Account Information

When the user clicks on the account number in the savings summary, he will be able to see his transaction history to the account along with the account details.

![Savings Account Info](screenshots/SavingsAccountInfo.png?raw=true "Savings Account Info")

### 8. Add Transaction

Here the user can register a transaction against his accounts. He can provide the transaction types as GROCERY, ENTERTAINMENT, TRANSPORTATION, MEDICAL EXPENSES, CREDIT BALANCE and INVESTMENT. He need to provide the account number, transaction amount and the transaction date.
If the transaction type is INVESTMENT, he has to select the savings account to which the transaction has to be made.
If the transaction type is CREDIT BALANCE, the transaction amount is added to his account, else it is deducted from the account.

![Add Transaction1](screenshots/AddTransaction1.png?raw=true "Add Transaction")

![Add Transaction2](screenshots/AddTransaction2.png?raw=true "Add Transaction")
