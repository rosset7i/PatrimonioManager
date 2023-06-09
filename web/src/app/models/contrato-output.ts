import {TipoContrato} from "./tipo-contrato";

export interface ContratoOutput{
  id: number;
  nome: string;
  nomeAgregado: string;
  dataInicio: Date;
  dataFinal: Date;
  tipoContrato: TipoContrato;
}
