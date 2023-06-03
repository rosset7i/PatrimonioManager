import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ContratoOutput} from "../models/contrato-output";
import {ContratoService} from "../services/contrato.service";
import {ModalActions} from "../models/actions";

@Component({
  selector: 'app-cadastrar-contrato-modal',
  templateUrl: './cadastrar-contrato-modal.component.html',
  styleUrls: ['./cadastrar-contrato-modal.component.css']
})
export class CadastrarContratoModalComponent implements OnInit{
  form: FormGroup;
  modalTitle;

  constructor(
    private contatoService: ContratoService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialog: MatDialogRef<any>) {
  }

  setupModal(){
    if (this.data == ModalActions.Veiculo)
      this.modalTitle = 'Veiculo';
    if (this.data == ModalActions.Imovel)
      this.modalTitle = 'Imovel';
    if (this.data == ModalActions.Equipamento)
      this.modalTitle = 'Equipamento';
  }

  get canSave() {
    return this.form.valid && this.form.dirty;
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.setupModal();

    this.form = this.formBuilder.group({
      nome: [null, Validators.required],
      idAgregado: [null, Validators.required],
      dataInicio: [null, Validators.required],
      dataFinal: [null, Validators.required],
    });

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  createContrato() {
    const contrato: ContratoOutput = this.form.value;
    if (this.data != undefined) {
      contrato.id = this.data.id;
    }

    return contrato;
  }

  saveContato() {
    const contrato = this.createContrato();

    if (contrato.id) {
      this.contatoService.updateContrato(contrato)
        .subscribe(() => this.dialog.close());
    } else {
      this.contatoService.createContrato(contrato)
        .subscribe(() => this.dialog.close());
    }
  }
}
