package br.com.unicesumar.aep.voo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/3esoft2019",
                "postgres",
                "unicesumar");


    }

    private static void execute(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    private static void inserir(Connection connection, BilheteAereo bilhete) {

    }

    public static void criarTabelaBilhete(Connection connection) throws Exception {
        String sql = "create table if not exists bilhete ("
                + "voo integer,"
                + "origem varchar(255),"
                + "destino varchar(255),"
                + "data date "
                + ")";

        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }
}
