import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ContratoService} from "../services/contrato.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ContratoOutput} from "../models/contrato-output";
import {ImovelService} from "../services/imoveis.service";
import {ImovelOutput} from "../models/imovel-output";

@Component({
  selector: 'app-cadastrar-imovel',
  templateUrl: './cadastrar-imovel.component.html',
  styleUrls: ['./cadastrar-imovel.component.css']
})
export class CadastrarImovelComponent implements OnInit{
  form: FormGroup;

  constructor(
    private imovelService: ImovelService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialog: MatDialogRef<any>) {
  }


  get canSave() {
    return this.form.valid && this.form.dirty;
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.form = this.formBuilder.group({
      nome: [null, Validators.required],
      descricao: [null, Validators.required],
      endereco: [null, Validators.required],
    });

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  createImovel() {
    const imovel: ImovelOutput = this.form.value;
    if (this.data != undefined) {
      imovel.id = this.data.id;
    }

    return imovel;
  }

  saveImovel() {
    const imovel = this.createImovel();

    if (imovel.id) {
      this.imovelService.updateImovel(imovel)
        .subscribe(() => this.dialog.close());
    } else {
      this.imovelService.createImovel(imovel)
        .subscribe(() => this.dialog.close());
    }
  }
}
