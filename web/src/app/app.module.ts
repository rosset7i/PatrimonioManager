import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContratosComponent } from './contratos/contratos.component';
import { ImoveisComponent } from './imoveis/imoveis.component';
import { EquipamentosComponent } from './equipamentos/equipamentos.component';
import { VeiculosComponent } from './veiculos/veiculos.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContratosComponent,
    ImoveisComponent,
    EquipamentosComponent,
    VeiculosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
