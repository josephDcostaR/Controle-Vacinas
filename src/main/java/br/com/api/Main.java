package br.com.api;

import spark.Spark;
import java.sql.Connection;
import br.com.api.config.Conexao;
import br.com.api.dao.DAOPaciente;
import br.com.api.routes.RotasPaciente;
import spark.Request;
import spark.Response;
import spark.Route;
import br.com.api.estatisticas.EstatisticasController;

public class Main {

    public static void main(String[] args) {
        try {
            // Obtém uma conexão válida com o banco de dados
            Connection conexao = Conexao.getConexao();

            // Atribui a conexão criada no atributo da classe DAOPaciente
            DAOPaciente.conexao = conexao;

            // Configura a porta do Spark
            Spark.port(8080);

            // Habilita CORS
            Spark.options("/*", new Route() {
                @Override
                public Object handle(Request requisicaoHttp, Response respostaHttp) throws Exception {
                    String accessControlRequestHeaders = requisicaoHttp.headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        respostaHttp.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = requisicaoHttp.headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        respostaHttp.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                    }

                    return "OK";
                }
            });

            // Configura os headers CORS para todas as requisições
            Spark.before((requisicaoHttp, respostaHttp) -> {
                respostaHttp.header("Access-Control-Allow-Origin", "*"); // Permite todas as origens
                respostaHttp.header("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
                respostaHttp.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
            });

            // Registra as rotas do paciente
            RotasPaciente.processarRotasPaciente();

            // Registra as rotas de estatísticas
            EstatisticasController.init();

            System.out.println("Servidor Spark iniciado na porta 8080.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao iniciar o servidor Spark: " + e.getMessage());
        }
    }
}