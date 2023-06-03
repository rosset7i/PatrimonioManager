import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ContratoOutput} from "../models/contrato-output";
import {ImovelOutput} from "../models/imovel-output";

@Injectable({
  providedIn: 'root'
})
export class ImovelService {
  private readonly baseUrl = 'api/v1/imoveis';

  constructor(private httpClient: HttpClient) { }

  getAllImoveis(){
    return this.httpClient.get<ImovelOutput[]>(this.baseUrl);
  }

  createImovel(contatoInput: ContratoOutput){
    return this.httpClient.post(this.baseUrl, contatoInput);
  }

  updateImovel(contratoInput: ContratoOutput){
    return this.httpClient.put(this.baseUrl, contratoInput);
  }

  deleteImovel(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
