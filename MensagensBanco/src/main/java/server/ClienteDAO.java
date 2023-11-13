
package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import tools.FactoryPostgres;

public class ClienteDAO {
    private Connection c;

    public ClienteDAO() {
        this.c = FactoryPostgres.getConexaoPostgres();
    }
    
    
    public boolean insert(Cliente cliente) {
        return true;
    }
    public ArrayList<Cliente> selectAll() {
        return null;
    }
    
    public Cliente selectByName() {
        return null;
    }
    
    public Cliente selectById() {
        return null;
    }
    
    public boolean setOnline(boolean online, long id) {
        String sql = "UPDATE Clientes SET online = ? WHERE id = ?";
        
        try(PreparedStatement trans = this.c.prepareStatement(sql)) {
            trans.setBoolean(1, online);
            trans.setLong(2, id);
            
            trans.execute();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
