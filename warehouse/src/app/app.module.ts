import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { WarehouseCapacityComponent } from './warehouse-capacity/warehouse-capacity.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { WarehouseEditComponent } from './warehouse/warehouse-edit.component';
import { WareComponent } from './ware/ware.component';
import { UsersComponent } from './users/users.component';
import {UsersEditComponent} from "./users/users-edit.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    FooterComponent,
    HeaderComponent,
    WarehouseComponent,
    WarehouseCapacityComponent,
    SidebarComponent,
    WarehouseEditComponent,
    WareComponent,
    UsersComponent,
    UsersEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
