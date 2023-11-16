
package server;

import java.sql.Connection;
import tools.FactoryPostgres;

public class ConversaDAO {
    private Connection c;
    
    public ConversaDAO() {
        this.c = FactoryPostgres.getConexaoPostgres();
    }
    
    public int select(int id_remetente, int id_destinatario) {
        String sql = "SELECT id FROM conversa WHERE cliente1 = ? OR ";
    }
}
