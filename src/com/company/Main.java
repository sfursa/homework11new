package com.company;


public class Main {

    public static void main(String[] args) {
        Address a1 = new Address(1, "Slutsk", "Tutarinova", 13);
        Address a2 = new Address(2, "Gorki", "Stroitelei", 20);
        Address a3 = new Address(3, "Minsk", "Kulman", 64);
        Address a4 = new Address(4, "Brest", "Pogran", 13);
        Address a5 = new Address(5, "Gorki", "Chehova", 1);

//        AddressConnector.save(a1);
//        AddressConnector.save(a2);
//        AddressConnector.save(a3);
//        AddressConnector.save(a4);
//        AddressConnector.save(a5);
//        Address n = AddressConnector.byId(1);
//        n.setCity("Mogilev");
//        boolean changed = AddressConnector.update(n);
//        System.out.println(changed);
        AddressConnector.delete(4);

        for (Address address : (new AddressConnector()).readAll()) {
            System.out.println(address);
        }
    }
}
