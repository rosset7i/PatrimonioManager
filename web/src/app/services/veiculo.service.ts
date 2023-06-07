import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
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

  createVeiculo(veiculoOutput: VeiculoOutput){
    return this.httpClient.post(this.baseUrl, veiculoOutput);
  }

  updateVeiculo(veiculoOutput: VeiculoOutput){
    return this.httpClient.put(this.baseUrl, veiculoOutput);
  }

  deleteVeiculo(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
