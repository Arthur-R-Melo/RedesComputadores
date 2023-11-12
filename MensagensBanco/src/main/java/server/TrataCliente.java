/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.Cliente;
import model.Mensagem;

/**
 *
 * @author arthu
 */
public class TrataCliente implements Runnable {

    private Socket soquete_cliente;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private ClienteDAO clienteDAO;

    public TrataCliente(Socket soquete_cliente) throws Exception {
        super();
        this.soquete_cliente = soquete_cliente;
        this.saida = new ObjectOutputStream(this.soquete_cliente.getOutputStream());
        this.entrada = new ObjectInputStream(this.soquete_cliente.getInputStream());
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
                comand = mensagem.getOperacao().split(",");
                switch (comand[0]) {
                    case "ENCERRAR":
                        
                        break OUTER;
                        
                    case "ENVIAR":
                        break;
                        
                    case "ENTRAR":
                        break;
                        
                    case "REGISTRAR":
                        break;
                        
                    case "LISTAR":
                        break;
                        
                    default:
                        throw new AssertionError();
                }

            } while (!mensagem.getTexto().equals("ENCERRAR"));
            System.out.println("\u001b[32m" + soquete_cliente + " - Desconectou!");
            finalizar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> listaClientes(String comand[]) {
        return null;
    }

    public ArrayList<Mensagem> listaMensagens(String comand[]) {
        return null;
    }
}
