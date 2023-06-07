import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ContratoService} from "../services/contrato.service";
import {ModalActions} from "../models/actions";
import {EquipamentoService} from "../services/equipamentos.service";
import {ImovelService} from "../services/imoveis.service";
import {VeiculoService} from "../services/veiculo.service";
import {SelectOutput} from "../models/select-output";
import {TipoContrato} from "../models/tipo-contrato";
import {CreateOrUpdateContatoInput} from "../models/create-contato-output";

@Component({
  selector: 'app-cadastrar-contrato-modal',
  templateUrl: './cadastrar-contrato-modal.component.html',
  styleUrls: ['./cadastrar-contrato-modal.component.css']
})
export class CadastrarContratoModalComponent implements OnInit{
  form: FormGroup;
  selectOptions: SelectOutput[];
  tipoContrato: TipoContrato;
  modalTitle;

  constructor(
    private contratoService: ContratoService,
    private equipamentoService: EquipamentoService,
    private imovelService: ImovelService,
    private veiculoService: VeiculoService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialog: MatDialogRef<any>) {
  }

  setupModal(){
    if (this.data == ModalActions.Veiculo){
      this.modalTitle = 'Veiculo';
      this.tipoContrato = TipoContrato.VEICULO;
      this.veiculoService.getAllVeiculos()
        .subscribe(response =>
          this.selectOptions = response.map(response => new SelectOutput(response.id,response.modelo)));
    }
    if (this.data == ModalActions.Imovel){
      this.modalTitle = 'Imovel';
      this.tipoContrato = TipoContrato.IMOVEL;
      this.imovelService.getAllImoveis()
        .subscribe(response =>
          this.selectOptions = response.map(response => new SelectOutput(response.id,response.nome)));
    }
    if (this.data == ModalActions.Equipamento){
      this.modalTitle = 'Equipamento';
      this.tipoContrato = TipoContrato.EQUIPAMENTO;
      this.equipamentoService.getAllEquipamentos()
        .subscribe(response =>
          this.selectOptions = response.map(response => new SelectOutput(response.id,response.nome)));
    }
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
      dataInicio: [null, Validators.required],
      dataFinal: [null, Validators.required],
      idAgregado: [null, Validators.required],
      tipoContrato: [this.tipoContrato, Validators.required],
    });

    if (this.data) {
      this.form.patchValue(this.data);
    }
  }

  createContrato() {
    let contrato: CreateOrUpdateContatoInput = {
      veiculo: null, id: null, imovel: null, tipoContrato: this.tipoContrato, equipamento: null,
      dataFinal: this.form.get('dataFinal').value,
      dataInicio: this.form.get('dataFinal').value,
      nome: this.form.get('nome').value
    };
    if(this.tipoContrato == TipoContrato.IMOVEL)
      contrato.imovel = this.form.get('idAgregado').value;
    if(this.tipoContrato == TipoContrato.EQUIPAMENTO)
      contrato.equipamento = this.form.get('idAgregado').value;
    if(this.tipoContrato == TipoContrato.VEICULO)
      contrato.veiculo = this.form.get('idAgregado').value;

    if (this.data != undefined) {
      contrato.id = this.data.id;
    }

    return contrato;
  }

  saveContrato() {
    const contrato = this.createContrato();

    if (contrato.id) {
      this.contratoService.updateContrato(contrato)
        .subscribe(() => this.dialog.close());
    } else {
      this.contratoService.createContrato(contrato)
        .subscribe(() => this.dialog.close());
    }
  }
}
