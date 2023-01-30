package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.ShoppingList.Server;

import it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.ShoppingList.Commons.DataStructure;

import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;


public class ServerLogic {
  DatagramSocket srvSocket;
  List<DataStructure> marketStructure = new ArrayList<DataStructure>();

    public void addItem(String name, Double price, String description){
        DataStructure item = new DataStructure(name, price, description);
        marketStructure.add(item);
    }
    public void removeItem(String name){
        marketStructure.remove()
    }
}