import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContratosComponent} from "./contratos/contratos.component";
import {ImoveisComponent} from "./imoveis/imoveis.component";
import {VeiculosComponent} from "./veiculos/veiculos.component";
import {EquipamentosComponent} from "./equipamentos/equipamentos.component";

const routes: Routes = [
  {
    path: 'contratos',
    component: ContratosComponent
  },
  {
    path: 'imoveis',
    component: ImoveisComponent
  },
  {
    path: 'veiculos',
    component: VeiculosComponent
  },
  {
    path: 'equipamentos',
    component: EquipamentosComponent
  },
  {
    path: '**',
    redirectTo: 'contratos'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
