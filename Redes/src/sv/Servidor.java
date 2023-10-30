package sv;

import sv.TrataCliente;
import java.net.Socket;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.io.IOException;
import cl.Mensagem;

public class Servidor {

    private ServerSocket soquete_servidor;
    private ArrayList<Mensagem> mensagens;
    private static ArrayList<TrataCliente> clientes;

    public Servidor(int porta) throws Exception {
        super();
        this.soquete_servidor = new ServerSocket(porta);
        this.mensagens = new ArrayList<Mensagem>();
    }

    public void finalizar() throws IOException {
        this.soquete_servidor.close();
    }

    public static void main(String[] args) throws Exception {
        Servidor servidor = new Servidor(15500);
        Servidor.clientes = new ArrayList<>();
        Socket soqueteCliente = null;
        while (true) {
            try {
                soqueteCliente = servidor.soquete_servidor.accept();
                Servidor.clientes.add(new TrataCliente(soqueteCliente, servidor.mensagens));
                new Thread(Servidor.clientes.get(Servidor.clientes.size()-1)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<TrataCliente> getClientes() {
        return clientes;
    }

}
