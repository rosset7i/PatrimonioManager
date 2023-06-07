import {Component, OnInit} from '@angular/core';
import {ImovelService} from "../services/imoveis.service";
import {ImovelOutput} from "../models/imovel-output";
import {MatDialog} from "@angular/material/dialog";
import {CadastrarImovelComponent} from "../cadastrar-imovel/cadastrar-imovel.component";

@Component({
  selector: 'app-imoveis',
  templateUrl: './imoveis.component.html',
  styleUrls: ['./imoveis.component.css']
})
export class ImoveisComponent implements OnInit{
  public imoveis: ImovelOutput[];

  constructor(
    private imovelService: ImovelService,
    private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.imovelService.getAllImoveis()
      .subscribe(response => this.imoveis = response);
  }

  abrirModalImovel(imovel?: ImovelOutput) {
    this.dialog.open(CadastrarImovelComponent, {data: imovel})
      .afterClosed()
      .subscribe(() => this.getData());
  }

  deleteImovel(id: number) {
    this.imovelService.deleteImovel(id)
      .subscribe(() => this.getData());
  }
}
