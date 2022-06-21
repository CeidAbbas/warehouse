import {Component, OnInit} from '@angular/core';
import {Warehouse} from "./warehouse";
import {WarehouseService} from './warehouse.service';

@Component({
  selector: 'app-warehouse-edit',
  templateUrl: './warehouse-edit.component.html',
  styleUrls: ['./warehouse-edit.component.css']
})
export class WarehouseEditComponent implements OnInit {

  public warehouse: Warehouse;

  constructor(private warehouseService: WarehouseService) {
    this.warehouse = new Warehouse;
  }

  ngOnInit(): void {
  }

  save() {
    console.log(this.warehouse);
    this.warehouseService.saveWarehouse(this.warehouse).subscribe(data =>{
      console.log(data);
    });
  }
}
