package ru.netology.domain.Product;

public class Smartphone extends Product {

    protected String manufacturer;

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);

        this.manufacturer = manufacturer;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
   @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getManufacturer().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
