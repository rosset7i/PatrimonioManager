import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ContratoOutput} from "../models/contrato-output";
import {VeiculoOutput} from "../models/veiculo-output";

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {
  private readonly baseUrl = 'api/v1/veiculos';

  constructor(private httpClient: HttpClient) { }

  getAllVeiculos(){
    return this.httpClient.get<VeiculoOutput[]>(this.baseUrl);
  }

  createVeiculo(contatoInput: ContratoOutput){
    return this.httpClient.post(this.baseUrl, contatoInput);
  }

  updateVeiculo(contratoInput: ContratoOutput){
    return this.httpClient.put(this.baseUrl, contratoInput);
  }

  deleteVeiculo(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
