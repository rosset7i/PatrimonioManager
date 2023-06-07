import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EquipamentoOutput} from "../models/equipamento-output";
import {EquipamentoService} from "../services/equipamentos.service";

@Component({
  selector: 'app-cadastrar-equipamento',
  templateUrl: './cadastrar-equipamento.component.html',
  styleUrls: ['./cadastrar-equipamento.component.css']
})
export class CadastrarEquipamentoComponent implements OnInit{
  form: FormGroup;

  constructor(
    private equipamentoService: EquipamentoService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: EquipamentoOutput,
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
      dataAquisicao: [null, Validators.required],
    });

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  createEquipamento() {
    const equipamentoOutput: EquipamentoOutput = this.form.value;
    if (this.data != undefined) {
      equipamentoOutput.id = this.data.id;
    }

    return equipamentoOutput;
  }

  saveEquipamento() {
    const equipamentoOutput = this.createEquipamento();

    if (equipamentoOutput.id) {
      this.equipamentoService.createEquipamentos(equipamentoOutput)
        .subscribe(() => this.dialog.close());
    } else {
      this.equipamentoService.updateEquipamentos(equipamentoOutput)
        .subscribe(() => this.dialog.close());
    }
  }
}
