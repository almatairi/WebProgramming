package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<> ();
    public static List<Manufacturer> manufacturers = new ArrayList<> ();
    public static List<Order> orders =new ArrayList<>();
    public static Order pendingOrder;

    @PostConstruct
    public void init(){
        Manufacturer manufacturer = new Manufacturer("Balloonz", "MKD", "JoskoIlievski 20");
        manufacturers.add(manufacturer);
        balloons.add (new Balloon ("Green balloon", "Small", manufacturer));

        manufacturer = new Manufacturer ("Balonat", "AL", "Brigada Zhan D'ark");
        manufacturers.add (manufacturer);
        balloons.add (new Balloon ("Blue balloon", "Medium", manufacturer));

        manufacturer = new Manufacturer ("Балони", "MKD", "BozidarADZIJA 15");
        manufacturers.add (manufacturer);
        balloons.add (new Balloon ("Red balloon", "Big", manufacturer));
    }
}
