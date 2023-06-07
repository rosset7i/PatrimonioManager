import {Component, OnInit} from '@angular/core';
import {VeiculoService} from "../services/veiculo.service";
import {VeiculoOutput} from "../models/veiculo-output";
import {MatDialog} from "@angular/material/dialog";
import {CadastrarVeiculoComponent} from "../cadastrar-veiculo/cadastrar-veiculo.component";

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent implements OnInit{
  public veiculos: VeiculoOutput[];

  constructor(
    private veiculoService:VeiculoService,
    private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.veiculoService.getAllVeiculos()
      .subscribe(response => this.veiculos = response)
  }

  abrirModalVeiculo(veiculoOutput?: VeiculoOutput) {
    this.dialog.open(CadastrarVeiculoComponent, {data: veiculoOutput})
      .afterClosed()
      .subscribe(() => this.getData());
  }

  deleteVeiculo(id:number) {
    this.veiculoService.deleteVeiculo(id)
      .subscribe(() => this.getData());
  }
}
