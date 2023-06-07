import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ContratoService} from "../services/contrato.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ModalActions} from "../models/actions";
import {ContratoOutput} from "../models/contrato-output";
import {VeiculoOutput} from "../models/veiculo-output";
import {VeiculoService} from "../services/veiculo.service";

@Component({
  selector: 'app-cadastrar-veiculo',
  templateUrl: './cadastrar-veiculo.component.html',
  styleUrls: ['./cadastrar-veiculo.component.css']
})
export class CadastrarVeiculoComponent implements OnInit{
  form: FormGroup;

  constructor(
    private veiculoService: VeiculoService,
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
      ano: [null, Validators.required],
      modelo: [null, Validators.required],
      placa: [null, Validators.required],
    });

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  createVeiculo() {
    const veiculo: VeiculoOutput = this.form.value;
    if (this.data != undefined) {
      veiculo.id = this.data.id;
    }

    return veiculo;
  }

  saveVeiculo() {
    const veiculo = this.createVeiculo();

    if (veiculo.id) {
      this.veiculoService.updateVeiculo(veiculo)
        .subscribe(() => this.dialog.close());
    } else {
      this.veiculoService.createVeiculo(veiculo)
        .subscribe(() => this.dialog.close());
    }
  }
}
