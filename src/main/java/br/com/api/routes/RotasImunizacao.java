package br.com.api.routes;

import br.com.api.routes.RotasImunizacao;
import br.com.api.service.ServicoImunizacao;


import spark.Spark; 

public class RotasImunizacao {
    
    public static void processarRotas(){
        
        //Rotas Imunização
        Spark.post("/imunizacao/inserir", ServicoImunizacao.cadastrarImunizacao());
        Spark.put("/imunizacao/alterar/:id", ServicoImunizacao.alterarImunizacao());
        Spark.delete("/imunizacao/excluir/:id", ServicoImunizacao.excluirImunizacao());
        Spark.delete("/imunizacao/excluir/paciente/:id", ServicoImunizacao.excluirTodos());
        Spark.get("/imunizacao/consultar/:id", ServicoImunizacao.consultarImunizacaoId());
        Spark.get("/imunizacao/consultar", ServicoImunizacao.consultarTodasImunizacoes());
        Spark.get("/imunizacao/consultar/paciente/:id", ServicoImunizacao.consultarImunizacaoPorPaciente());
        Spark.get("/imunizacao/consultar/paciente/:id/aplicacao/:dt_ini/:dt_fim", ServicoImunizacao.consultarImunizacaoPorIntervalo());

        
        //TO DO: Para criar novas rotas, basta adicionar novas linhas seguindo o padrao abaixo, 
        //onde XXXX e o metodo http (post, get, put ou delete), yyyyyy a url que define a rota
        //e ZZZZZ o metodo a ser executado quando a rota for acionada
        //Spark.XXXXX("YYYYYYY", ZZZZZ);
    }
    
    //Para criar novos metodos basta utilizar o esqueleto abaixo
    //Metodo Esqueleto
    //XXXX: Nome do metodo que o usuario quer criar
    //YYYY: Parametros de entrada para o metodo se existirem
    //ZZZZ: Implementação do método
    //QQQQ: Status code do HTTP
    //SSSS: Informação que será retornado
    //
    // public static Route XXXX(YYYY) {
    //     return new Route() {
    //         @Override
    //         public Object handle(Request request, Response response) throws Exception {
    //
    //             ZZZZ
    //
    //             response.status(QQQQ); 
    //             return SSSS;
    //         }
    //     };
    // }
}