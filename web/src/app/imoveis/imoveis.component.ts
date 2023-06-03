import {Component, OnInit} from '@angular/core';
import {ImovelService} from "../services/imoveis.service";
import {ImovelOutput} from "../models/imovel-output";

@Component({
  selector: 'app-imoveis',
  templateUrl: './imoveis.component.html',
  styleUrls: ['./imoveis.component.css']
})
export class ImoveisComponent implements OnInit{
  public imoveis: ImovelOutput[];

  constructor(
    private imovelService: ImovelService) {
  }

  ngOnInit(): void {
    this.imovelService.getAllImoveis()
      .subscribe(response => this.imoveis = response);
  }

}
