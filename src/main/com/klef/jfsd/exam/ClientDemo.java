package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // Insert Device
            Device device = new Device();
            device.setBrand("GenericBrand");
            device.setModel("GenericModel");
            device.setPrice(1000);
            session.save(device);

            // Insert Smartphone
            Smartphone smartphone = new Smartphone();
            smartphone.setBrand("Apple");
            smartphone.setModel("iPhone 15");
            smartphone.setPrice(1200);
            smartphone.setOperatingSystem("iOS");
            smartphone.setCameraResolution(48);
            session.save(smartphone);

            // Insert Tablet
            Tablet tablet = new Tablet();
            tablet.setBrand("Samsung");
            tablet.setModel("Galaxy Tab S8");
            tablet.setPrice(800);
            tablet.setScreenSize(12.4);
            tablet.setBatteryLife(14);
            session.save(tablet);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
