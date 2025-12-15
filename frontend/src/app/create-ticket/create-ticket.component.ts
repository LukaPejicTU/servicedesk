import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {TicketService} from '../services/ticket.service';
import {Router} from '@angular/router';
import {tick} from '@angular/core/testing';

@Component({
  selector: 'app-create-ticket',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-ticket.component.html',
  styleUrl: './create-ticket.component.css'
})
export class CreateTicketComponent {

  ticket = {
    title: '',
    description: '',
    priority: 'LOW',
    userId: 1
  };

  constructor(private ticketService: TicketService, private router: Router) {}

  onSubmit() {
    this.ticketService.createTicket(this.ticket).subscribe({
      next: (response) => {
        console.log('Ticket created!', response);

        this.router.navigate(['/tickets']);
      },
      error: (err) => {
        console.error('Something went wrong:', err);
      }
    });
  }

  protected readonly tick = tick;
}
