import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ContratoOutput} from "../models/contrato-output";

@Injectable({
  providedIn: 'root'
})
export class EquipamentoService {
  private readonly baseUrl = 'api/v1/equipamentos';

  constructor(private httpClient: HttpClient) { }

  getAllEquipamentos(){
    return this.httpClient.get(this.baseUrl);
  }

  createEquipamentos(contatoInput: ContratoOutput){
    return this.httpClient.post(this.baseUrl, contatoInput);
  }

  updateEquipamentos(contratoInput: ContratoOutput){
    return this.httpClient.put(this.baseUrl, contratoInput);
  }

  deleteEquipamento(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
