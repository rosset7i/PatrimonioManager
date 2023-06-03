import { Component } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {CadastrarContratoModalComponent} from "../cadastrar-contrato-modal/cadastrar-contrato-modal.component";
import {ModalActions} from "../models/actions";

@Component({
  selector: 'app-contratos',
  templateUrl: './contratos.component.html',
  styleUrls: ['./contratos.component.css']
})
export class ContratosComponent {
  public actions = ModalActions;

  constructor(private dialog: MatDialog) {
  }

  openCreateModal(modalAction: ModalActions){
    this.dialog.open(CadastrarContratoModalComponent, { data: modalAction} );
  }
}
