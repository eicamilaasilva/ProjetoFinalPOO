
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por estabelecer a conexão entre a aplicação
 * FocusUp e o banco de dados MySQL.
 *
 * @author Camila
 * @version 1.0
 */
public class Conexao {
    
    // Dados de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/focusup";
    private static final String USUARIO = "root";
    private static final String SENHA = "5802";

    /**
     * Estabelece e retorna uma conexão com o banco de dados.
     *
     * @return conexão ativa com o banco de dados MySQL.
     * @throws SQLException caso ocorra algum erro durante a conexão.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    /**
     * Método utilizado para testar a conexão com o banco de dados.
     *
     * @param args argumentos recebidos pela aplicação.
     */
    public static void main(String[] args) {
        try (Connection conexao = getConnection()) {
            System.out.println("Conexão aberta com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}
