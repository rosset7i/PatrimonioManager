import {Component, OnInit} from '@angular/core';
import {VeiculoService} from "../services/veiculo.service";
import {VeiculoOutput} from "../models/veiculo-output";

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent implements OnInit{
  public veiculos: VeiculoOutput[];

  constructor(
    private veiculoService:VeiculoService) {
  }

  ngOnInit(): void {
    this.veiculoService.getAllVeiculos()
      .subscribe(response => this.veiculos = response)
  }

}
