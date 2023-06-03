import {Component, OnInit} from '@angular/core';
import {EquipamentoOutput} from "../models/equipamento-output";
import {EquipamentoService} from "../services/equipamentos.service";

@Component({
  selector: 'app-equipamentos',
  templateUrl: './equipamentos.component.html',
  styleUrls: ['./equipamentos.component.css']
})
export class EquipamentosComponent implements OnInit{
  public equipamentos: EquipamentoOutput[];

  constructor(
    private equipamentoService: EquipamentoService) {
  }

  ngOnInit(): void {
    this.equipamentoService.getAllEquipamentos()
      .subscribe(response => this.equipamentos = response);
  }

}
