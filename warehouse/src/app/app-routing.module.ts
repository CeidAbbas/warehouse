import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoginComponent} from "./login/login.component";
import {UsersComponent} from './users/users.component';
import {WareComponent} from './ware/ware.component';
import {WarehouseCapacityComponent} from './warehouse-capacity/warehouse-capacity.component';
import {WarehouseComponent} from './warehouse/warehouse.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'users', component: UsersComponent},
  {path: 'warehouse', component: WarehouseComponent},
  {path: 'warehouseCapacity', component: WarehouseCapacityComponent},
  {path: 'ware', component: WareComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
