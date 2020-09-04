import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './components/app/app-routing.module';
import { AppComponent } from './components/app/app.component';
import { StockExchangeComponent } from './components/stock-exchange/stock-exchange.component';
import {StockExchangeService} from './services/stock-exchange.service';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatDividerModule} from '@angular/material/divider';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTabsModule} from '@angular/material/tabs';
import {FormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { SectorComponent } from './components/sector/sector.component';
import {SectorService} from './services/sector.service';
import { CompanyComponent } from './components/company/company.component';
import {CompanyService} from './services/company.service';
import { StockComponent } from './components/stock/stock.component';
import {StockService} from './services/stock.service';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { UserComponent } from './components/user/user.component';
import {UserService} from './services/user.service';
import { ContentComponent } from './components/content/content.component';
import {MatIconModule} from '@angular/material/icon';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    StockExchangeComponent,
    SectorComponent,
    CompanyComponent,
    StockComponent,
    UserComponent,
    ContentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatDividerModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatTableModule,
    MatPaginatorModule,
    MatTabsModule,
    MatSelectModule,
    ChartsModule,
    MatIconModule,
    MatTooltipModule,
    MatDialogModule
  ],
  providers: [StockExchangeService, SectorService, CompanyService, StockService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
