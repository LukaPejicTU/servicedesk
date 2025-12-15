import { Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {TicketListComponent} from './ticket-list/ticket-list.component';
import {CreateTicketComponent} from './create-ticket/create-ticket.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'tickets', component: TicketListComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'create-ticket', component: CreateTicketComponent }
];
