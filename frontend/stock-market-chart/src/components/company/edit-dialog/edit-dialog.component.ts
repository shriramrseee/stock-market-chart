import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CompanyService } from '../../../services/company.service';


@Component({
  selector: 'app-edit-dialog',
  templateUrl: './edit-dialog.component.html',
  styleUrls: ['./edit-dialog.component.css']
})
export class CompanyEditDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<CompanyEditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
    public companyService: CompanyService          
  ) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  save(): void {
    this.companyService.updateCompanyDetails(this.data).subscribe(res => {
      console.log(res)
    });
  }
}
