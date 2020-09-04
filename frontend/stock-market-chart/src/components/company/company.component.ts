import {Component, OnInit} from '@angular/core';
import {StockExchange} from '../../models/stock-exchange';
import {StockExchangeService} from '../../services/stock-exchange.service';
import {CompanyService} from '../../services/company.service';
import {Company} from '../../models/company';
import {IPO} from '../../models/ipo';
import {SectorService} from '../../services/sector.service';
import {Sector} from '../../models/sector';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  stockExchanges: StockExchange[];
  sectors: Sector[];
  companies: Company[];
  formCompany: Company;
  formIPO: IPO;

  displayedColumns = ['name', 'brief', 'ceo', 'sector', 'stock exchange',
   'IPO open', 'IPO close', 'price', 'count', 'actions'];

  constructor(private stockExchangeService: StockExchangeService
            , private companyService: CompanyService
            , public userService: UserService
            , private sectorService: SectorService) {
    this.initForm();
  }

  ngOnInit(): void {
   this.getCompanies();
  }

  initForm(): void {
    this.formCompany = new Company();
    this.formIPO = new IPO();
    this.formCompany.ipo = this.formIPO;
    this.formCompany.sector = new Sector();
    this.formCompany.stockExchanges = [new StockExchange()];
    this.getSectors();
    this.getStockExchanges();
  }

  getStockExchanges(): void {
    this.stockExchangeService.getStockExchanges().subscribe(res => {
      this.stockExchanges = res;
      this.formCompany.stockExchanges = [this.stockExchanges[0]];
    });
  }

  getSectors(): void {
    this.sectorService.getSectors().subscribe(res => {
      this.sectors = res;
      this.formCompany.sector = this.sectors[0];
    });
  }

  getCompanies(): void {
    this.companyService.getCompanys().subscribe(res => {
      this.companies = res;
    });
  }

  add(): void {
    this.companyService.addCompany(this.formCompany).subscribe(res => {
      this.initForm();
      this.getCompanies();
    });
  }

  delete(id: any): void {
    this.companyService.deleteCompany(id).subscribe(res => {
      this.initForm();
      this.getCompanies();
    });
  }
  
}
