
package server;

import java.sql.Connection;
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
    
    public boolean setOnline(boolean online) {
        return true;
    }
}
