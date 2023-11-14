
package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensagem;
import tools.FactoryPostgres;

public class MensagemDAO {
    
    private Connection c;

    public MensagemDAO() {
        this.c = FactoryPostgres.getConexaoPostgres();
    }
    
    public boolean insert(Mensagem mensagem) {
        return true;
    }
    
    public ArrayList<Mensagem> select(int id_remetente, int id_destinatario){
        ArrayList<Mensagem> retorno = new ArrayList<>();
        return retorno;
    }
    
        public ArrayList<Mensagem> select(){
        ArrayList<Mensagem> retorno = new ArrayList<>();
        String sql = "SELECT m.id, m.texto, c.nome FROM mensagens M WHERE id_conversa = 0 JOIN clientes C ON C.id = M.id_remetente ORDER BY id";
        try(PreparedStatement trans = c.prepareStatement(sql)) {
            ResultSet resultado = trans.executeQuery();
            
            while(resultado.next()) {
                Mensagem msg = new Mensagem(resultado.getString("c.nome"), 
                        resultado.getInt("m.id"), 
                        resultado.getString("m.texto"));
                retorno.add(msg);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MensagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
