import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ContratoOutput} from "../models/contrato-output";
import {CreateOrUpdateContatoInput} from "../models/create-contato-output";

@Injectable({
  providedIn: 'root'
})
export class ContratoService {
  private readonly baseUrl = 'api/v1/contratos';

  constructor(private httpClient: HttpClient) { }

  getAllContratos(){
    return this.httpClient.get<ContratoOutput[]>(this.baseUrl);
  }

  createContrato(contatoInput: CreateOrUpdateContatoInput){
    return this.httpClient.post(this.baseUrl, contatoInput);
  }

  updateContrato(contratoInput: CreateOrUpdateContatoInput){
    return this.httpClient.put(this.baseUrl, contratoInput);
  }

  deleteContrato(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
