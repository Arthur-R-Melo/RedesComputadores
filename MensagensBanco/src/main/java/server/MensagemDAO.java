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
        String sql = "SELECT INTO mensagens(texto, id_remetente, id_conversa) VALUES (?,?,?) returning id";
        try (PreparedStatement trans = c.prepareStatement(sql)) {
            trans.setString(1, mensagem.getTexto());
            trans.setInt(2, (int) mensagem.getId_remetente());
            trans.setInt(3, (int) mensagem.getId_conversa());

            ResultSet result = trans.executeQuery();
            if (result.next()) {
                mensagem.setId(result.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MensagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public ArrayList<Mensagem> select(int id_conversa) {
        ArrayList<Mensagem> retorno = new ArrayList<>();
        String sql = "SELECT M.id, M.texto, C.nome FROM mensagens M WHERE id_conversa = ? JOIN clientes C ON C.id = M.id_remetente ORDER BY id";
        try (PreparedStatement trans = c.prepareStatement(sql)) {
            trans.setInt(1, id_conversa);

            ResultSet resultado = trans.executeQuery();

            while (resultado.next()) {
                Mensagem msg = new Mensagem(resultado.getString("C.nome"),
                        resultado.getInt("M.id"),
                        resultado.getString("M.texto"));
                retorno.add(msg);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MensagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ArrayList<Mensagem> select() {
        ArrayList<Mensagem> retorno = new ArrayList<>();
        String sql = "SELECT M.id, M.texto, C.nome FROM mensagens M WHERE id_conversa = 0 JOIN clientes C ON C.id = M.id_remetente ORDER BY id";
        try (PreparedStatement trans = c.prepareStatement(sql)) {
            ResultSet resultado = trans.executeQuery();

            while (resultado.next()) {
                Mensagem msg = new Mensagem(resultado.getString("C.nome"),
                        resultado.getInt("M.id"),
                        resultado.getString("M.texto"));
                retorno.add(msg);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MensagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
