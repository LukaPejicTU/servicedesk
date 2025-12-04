import { Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {TicketListComponent} from './ticket-list/ticket-list.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'tickets', component: TicketListComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];
