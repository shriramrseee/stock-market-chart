import {Component, OnInit, ViewChild} from '@angular/core';
import {StockExchange} from '../../models/stock-exchange';
import {Company} from '../../models/company';
import {StockExchangeService} from '../../services/stock-exchange.service';
import {CompanyService} from '../../services/company.service';
import {Stock} from '../../models/stock';
import {StockService} from '../../services/stock.service';
import {ChartDataSets, ChartOptions} from 'chart.js';
import {BaseChartDirective, Color, Label} from 'ng2-charts';
import {StockFilter} from '../../models/stock-filter';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  stockExchanges: StockExchange[];
  companies: Company[];
  stocks: Stock[];
  formStock: Stock;
  stockFilter: StockFilter;

  lineChartData: ChartDataSets[];
  lineChartLabels: Label[];
  lineChartLegend = true;
  lineChartType = 'line';
  lineChartPlugins = [];

  @ViewChild(BaseChartDirective)
  public chart: BaseChartDirective;

  constructor(private stockExchangeService: StockExchangeService
            , private companyService: CompanyService
            , private stockService: StockService) {
    this.initForm();
    this.lineChartData = [{label: 'stocks', data: []}];
    this.stockFilter = new StockFilter();
  }

  ngOnInit(): void {
  }

  initForm(): void {
    this.formStock = new Stock();
    this.getStockExchanges();
    this.getCompanies();
  }

  getStockExchanges(): void {
    this.stockExchangeService.getStockExchanges().subscribe(res => {
      this.stockExchanges = res;
      this.formStock.stockExchange = this.stockExchanges[0];
    });
  }

  getCompanies(): void {
    this.companyService.getCompanys().subscribe(res => {
      this.companies = res;
      this.formStock.company = this.companies[0];
    });
  }

  add(): void {
    this.formStock.company.stockExchanges = [];
    this.stockService.addStock(this.formStock).subscribe(res => {
      this.initForm();
    });
  }

  getStocks(): void {
    this.stockService.getStocks(this.stockFilter).subscribe(res => {
      this.stocks = res;
      const t = [];
      const tt = [];
      for (const s of this.stocks) {
        t.push(s.closePrice);
        tt.push(s.date);
      }
      this.lineChartData = [{label: 'stocks', data: t}];
      this.lineChartLabels = tt;
      this.chart.chart.update();
    });
  }

}
