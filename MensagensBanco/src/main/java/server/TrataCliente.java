/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
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
    private int id;

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
                comand = mensagem.getOperacao().split(";");
                switch (comand[0]) {
                    case "ENCERRAR":
                        clienteDAO.setOnline(false, id);
                        break OUTER;

                    case "ENVIAR":
                        break;

                    case "ENTRAR":
                        Cliente cliente = clienteDAO.selectByName(comand[1]);
                        if (cliente == null) {
                            cliente = new Cliente();
                            cliente.setNome(comand[1]);
                            cliente.setOnline(true);
                            if(clienteDAO.insert(cliente)){
                                this.id = (int)cliente.getId();
                                enviar_mensagem("OK");
                            }else {
                                enviar_mensagem("ERRO");
                            }
                        } else {
                            if(cliente.isOnline()){
                                enviar_mensagem("ERRO");
                            }else {
                                enviar_mensagem("OK");
                                cliente.setOnline(true);
                                clienteDAO.setOnline(true, cliente.getId());
                                this.id = (int)cliente.getId();
                            }
                        }

                        break;

                    case "LISTAR":
                        if(comand[1].equals("CLIENTES")) {
                            enviar_mensagem(clienteDAO.selectAll());
                        } else if(comand[1].equals("MENSAGENS")){
                            
                        }else {
                            enviar_mensagem(null);
                        }
                        break;

                    default:
                        throw new AssertionError();
                }

            } while (!mensagem.getTexto().equals("ENCERRAR"));
            System.out.println("\u001b[32m" + soquete_cliente + " - Desconectou!");
            finalizar();
        } catch (SocketException ex) {

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Mensagem> listaMensagens(String comand[]) {
        return null;
    }
}
