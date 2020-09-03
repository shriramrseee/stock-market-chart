import { Component, OnInit } from '@angular/core';
import {Sector} from '../../models/sector';
import {SectorService} from '../../services/sector.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-sector',
  templateUrl: './sector.component.html',
  styleUrls: ['./sector.component.css']
})
export class SectorComponent implements OnInit {

  sectors: Sector[];
  formSector: Sector;

  displayedColumns = ['name', 'brief'];

  constructor(private sectorService: SectorService
            , public userService: UserService
  ) {
    this.initForm();
  }

  ngOnInit(): void {
    this.get();
  }

  initForm(): void {
    this.formSector = new Sector();
  }

  get(): void {
    this.sectorService.getSectors().subscribe(res => {
      this.sectors = res;
    });
  }

  add(): void {
    this.sectorService.addSector(this.formSector).subscribe(res => {
      this.initForm();
      this.get();
    });
  }

}
