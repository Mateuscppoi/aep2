package br.com.unicesumar.aep.voo;

import lombok.Data;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class BilheteService implements BilheteAereoRepository{

    private Connection connection;

    public BilheteService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void inserir(BilheteAereo bilhete) throws SQLException {
        String sql = String.format("insert into bilhete if exists values (%d, %s, %s, %s)", bilhete.getVoo(), bilhete.getOrigem(), bilhete.getDestino(), bilhete.getData());
        execute(sql);
    }

    @Override
    public List<BilheteAereo> buscarBilhetes() throws SQLException {
        String sql = "select * from bilhete";
        List<BilheteAereo> bilhetes = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Integer voo = resultSet.getInt("voo");
            String origem = resultSet.getString("origem");
            String destino = resultSet.getString("destino");
            Date data = resultSet.getDate("data");
            bilhetes.add(new BilheteAereo(voo, origem, destino, data));
        }
        statement.getResultSet();
        statement.close();
        return bilhetes;
    }

    @Override
    public void alterar(BilheteAereo bilhete) {
        String sql = "update bilhete set (?) as (?)"

    }

    @Override
    public void excluir(int voo) {

    }

    private void execute (String sql) throws SQLException {
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        statement.close();
    }
}
