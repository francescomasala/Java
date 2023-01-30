package it.tn.buonarroti.masala.tipsit.quarta.Sockets.UDP.Esercizi.ShoppingList.Commons;

public class DataStructure {
  String Name;
  Double Price;
  String Description;

    public DataStructure(String name, Double price, String description){
        this.Name = name;
        this.Price = price;
        this.Description = description;
    }
    
    public Double getPrice() {
        return Price;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return Name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}