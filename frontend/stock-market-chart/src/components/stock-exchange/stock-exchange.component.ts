import {Component, OnInit, ViewChild} from '@angular/core';
import {StockExchangeService} from '../../services/stock-exchange.service';
import {StockExchange} from '../../models/stock-exchange';
import {Contact} from '../../models/contact';
import {MatPaginator} from '@angular/material/paginator';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-stock-exchange',
  templateUrl: './stock-exchange.component.html',
  styleUrls: ['./stock-exchange.component.css']
})
export class StockExchangeComponent implements OnInit {

  stockExchanges: StockExchange[];
  formContact: Contact;
  formStockExchange: StockExchange;

  displayedColumns = ['name', 'brief', 'city', 'email', 'phone', 'state', 'zip'];

  constructor(private stockExchangeService: StockExchangeService
            , public userService: UserService
  ) {
    this.initForm();
  }

  ngOnInit(): void {
    this.get();
  }

  initForm(): void {
    this.formContact = new Contact();
    this.formStockExchange = new StockExchange();
    this.formStockExchange.contact = this.formContact;
  }

  get(): void {
    this.stockExchangeService.getStockExchanges().subscribe(res => {
      this.stockExchanges = res;
    });
  }

  add(): void {
    this.stockExchangeService.addStockExchange(this.formStockExchange).subscribe(res => {
        this.initForm();
        this.get();
    });
  }

}
