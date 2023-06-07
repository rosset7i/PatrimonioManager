import {Component, OnInit} from '@angular/core';
import {EquipamentoOutput} from "../models/equipamento-output";
import {EquipamentoService} from "../services/equipamentos.service";
import {MatDialog} from "@angular/material/dialog";
import {CadastrarEquipamentoComponent} from "../cadastrar-equipamento/cadastrar-equipamento.component";

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css']
})
export class EquipamentosComponent implements OnInit{
  public equipamentos: EquipamentoOutput[];

  constructor(
    private equipamentoService: EquipamentoService,
    private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.equipamentoService.getAllEquipamentos()
      .subscribe(response => this.equipamentos = response);
  }

  abrirModalEquipamento(equipamentoOutput?: EquipamentoOutput) {
    this.dialog.open(CadastrarEquipamentoComponent, { data: equipamentoOutput})
      .afterClosed()
      .subscribe(() => this.getData());
  }

  deleteEquipamento(id: number) {
    this.equipamentoService.deleteEquipamento(id)
      .subscribe(() => this.getData());
  }
}
