import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EquipamentoOutput} from "../models/equipamento-output";

@Injectable({
  providedIn: 'root'
})
export class EquipamentoService {
  private readonly baseUrl = 'api/v1/equipamentos';

  constructor(private httpClient: HttpClient) { }

  getAllEquipamentos(){
    return this.httpClient.get<EquipamentoOutput[]>(this.baseUrl);
  }

  createEquipamentos(equipamentoOutput: EquipamentoOutput){
    return this.httpClient.post(this.baseUrl, equipamentoOutput);
  }

  updateEquipamentos(equipamentoOutput: EquipamentoOutput){
    return this.httpClient.put(this.baseUrl, equipamentoOutput);
  }

  deleteEquipamento(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
