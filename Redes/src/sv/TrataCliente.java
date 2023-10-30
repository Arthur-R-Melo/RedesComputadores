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
            do {
                mensagem = (Mensagem) receber_mensagem();
                comand = mensagem.getTexto().split(";");

                if (comand[0].equals("ENCERRAR")) {
                    break;
                } else if (comand[0].equals("ENVIAR")) {
                    mensagem.setTexto(comand[1]);
                    this.mensagens.add(mensagem);
                } else if (comand[0].equals("LISTAR")) {
                    if (comand[1].equals("CLIENTES")) {
                        enviar_mensagem(Servidor.getClientes());
                    } else if (comand[1].equals("MENSAGENS")) {
                        enviar_mensagem(this.mensagens);
                    }
                }
            } while (!mensagem.equals("ENCERRAR"));
            finalizar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
