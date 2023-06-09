import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContratosComponent } from './contratos/contratos.component';
import { ImoveisComponent } from './imoveis/imoveis.component';
import { EquipamentosComponent } from './equipamentos/equipamentos.component';
import { VeiculosComponent } from './veiculos/veiculos.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CadastrarContratoModalComponent } from './cadastrar-contrato-modal/cadastrar-contrato-modal.component';
import {MatDialogModule} from "@angular/material/dialog";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CadastrarImovelComponent } from './cadastrar-imovel/cadastrar-imovel.component';
import { CadastrarVeiculoComponent } from './cadastrar-veiculo/cadastrar-veiculo.component';
import { CadastrarEquipamentoComponent } from './cadastrar-equipamento/cadastrar-equipamento.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContratosComponent,
    ImoveisComponent,
    EquipamentosComponent,
    VeiculosComponent,
    CadastrarContratoModalComponent,
    CadastrarImovelComponent,
    CadastrarVeiculoComponent,
    CadastrarEquipamentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDialogModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
