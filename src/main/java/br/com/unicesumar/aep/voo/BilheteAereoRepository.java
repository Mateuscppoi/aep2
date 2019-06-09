package br.com.unicesumar.aep.voo;

import java.sql.SQLException;
import java.util.List;

public interface BilheteAereoRepository {

    void inserir(BilheteAereo bilhete) throws SQLException;
    List<BilheteAereo> buscarBilhetes() throws SQLException;
    void alterar(BilheteAereo bilhete);
    void excluir(int voo);

}
