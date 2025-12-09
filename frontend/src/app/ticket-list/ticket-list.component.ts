import {Component, OnInit} from '@angular/core';
import {Ticket, TicketService} from '../services/ticket.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-ticket-list',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './ticket-list.component.html',
  styleUrl: './ticket-list.component.css'
})
export class TicketListComponent implements OnInit {

  constructor(private ticketService: TicketService) { }

  tickets: Ticket[] = [];

  ngOnInit(): void {
    this.ticketService.getTickets()
      .subscribe({
        next: (data) => {
          this.tickets = data;
        },

        error: (err) => {
          console.log("Error fetching the tickets!")
        }
      })
  }
}
