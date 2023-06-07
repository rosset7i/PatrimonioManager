import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
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

  createImovel(imovelOutput: ImovelOutput){
    return this.httpClient.post(this.baseUrl, imovelOutput);
  }

  updateImovel(imovelOutput: ImovelOutput){
    return this.httpClient.put(this.baseUrl, imovelOutput);
  }

  deleteImovel(id: number){
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
