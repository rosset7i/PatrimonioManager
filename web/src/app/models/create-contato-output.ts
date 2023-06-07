import {TipoContrato} from "./tipo-contrato";

export interface CreateOrUpdateContatoInput{
  id: number;
  nome: string;
  veiculo: number;
  equipamento: number;
  imovel: number;
  dataInicio: Date;
  dataFinal: Date;
  tipoContrato: TipoContrato;
}
