import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NgbModule, NgbProgressbarModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { UserDashboardComponent } from './user-workflow/user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserInfoComponent } from './user-workflow/user-info/user-info.component';
import { TransactionSummaryComponent } from './user-workflow/transaction-summary/transaction-summary.component';
import { SavingsSummaryComponent } from './user-workflow/savings-summary/savings-summary.component';
import { AccountSummaryComponent } from './user-workflow/account-summary/account-summary.component';
import { AddAccountComponent } from './user-workflow/add-account/add-account.component';
import { AddTransactionComponent } from './user-workflow/add-transaction/add-transaction.component';
import { AddSavingsAccountComponent } from './user-workflow/add-savings-account/add-savings-account.component';
import { SavingsAccountDetailsComponent } from './user-workflow/savings-account-details/savings-account-details.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    RegisterUserComponent,
    UserInfoComponent,
    TransactionSummaryComponent,
    SavingsSummaryComponent,
    AccountSummaryComponent,
    AddAccountComponent,
    AddTransactionComponent,
    AddSavingsAccountComponent,
    SavingsAccountDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbProgressbarModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
