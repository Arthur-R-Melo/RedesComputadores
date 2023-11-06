package sv;

import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import cl.Mensagem;

public class TrataCliente implements Runnable {

    private Socket soquete_cliente;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private ArrayList<Mensagem> mensagens;

    public TrataCliente(Socket soquete_cliente, ArrayList<Mensagem> mensagens) throws Exception {
        super();
        this.soquete_cliente = soquete_cliente;
        this.saida = new ObjectOutputStream(this.soquete_cliente.getOutputStream());
        this.entrada = new ObjectInputStream(this.soquete_cliente.getInputStream());
        this.mensagens = mensagens;
        Servidor.addCliente(this.soquete_cliente.getInetAddress().toString());
    }

    public void enviar_mensagem(Object mensagem) throws Exception {
        this.saida.writeObject(mensagem);
    }

    public Object receber_mensagem() throws Exception {
        return this.entrada.readObject();
    }

    public void finalizar() throws IOException {
        this.soquete_cliente.close();
    }

    @Override
    public void run() {
        try {
            Mensagem mensagem;
            String comand[];
            OUTER:
            do {
                mensagem = (Mensagem) receber_mensagem();
                System.out.println(mensagem);
                comand = mensagem.getTexto().split(";");
                switch (comand[0]) {
                    case "ENCERRAR":
                        Servidor.removeCliente(this.soquete_cliente.getInetAddress().toString());
                        break OUTER;
                    case "ENVIAR":
                        mensagem.setTexto(comand[1]);
                        this.mensagens.add(mensagem);
                        break;
                    case "LISTAR":
                        if (comand[1].equals("CLIENTES")) {
                            ArrayList<String> clientes = new ArrayList<>();
                            clientes.addAll(Servidor.getClientes());
                            enviar_mensagem(clientes);
                        } else if (comand[1].equals("MENSAGENS")) {
                            ArrayList<Mensagem> msg = new ArrayList<>();
                            msg.addAll(this.mensagens);
                            enviar_mensagem(msg);
                        }   break;
                    default:
                        break;
                }
            } while (!mensagem.equals("ENCERRAR"));
            System.out.println("\u001b[32m" + soquete_cliente + " - Desconectou!");
            finalizar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
