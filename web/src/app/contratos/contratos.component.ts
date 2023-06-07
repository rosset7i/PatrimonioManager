import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {CadastrarContratoModalComponent} from "../cadastrar-contrato-modal/cadastrar-contrato-modal.component";
import {ModalActions} from "../models/actions";
import {ContratoOutput} from "../models/contrato-output";
import {ContratoService} from "../services/contrato.service";

@Component({
  selector: 'app-contratos',
  templateUrl: './contratos.component.html',
  styleUrls: ['./contratos.component.css']
})
export class ContratosComponent implements OnInit{
  public actions = ModalActions;
  public contratos: ContratoOutput[];

  constructor(
    private dialog: MatDialog,
    private contratoService: ContratoService) {
  }

  ngOnInit(): void {
    this.getData();
  }

  private getData(){
    this.contratoService.getAllContratos()
      .subscribe(response => this.contratos = response);
  }

  openCreateModal(modalAction: ModalActions){
    this.dialog.open(CadastrarContratoModalComponent, { data: modalAction} )
      .afterClosed()
      .subscribe(() => this.getData());
  }

  abrirModalContrato(contrato: ContratoOutput) {
    this.dialog.open(CadastrarContratoModalComponent, { data: contrato} )
      .afterClosed()
      .subscribe(() => this.getData());

  }

  deleteContrato(id: number) {
    this.contratoService.deleteContrato(id)
      .subscribe(() => this.getData());
  }
}
