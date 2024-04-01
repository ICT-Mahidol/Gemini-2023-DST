

public class OldVehicle {
        // fields

        String type;
        String model;
        String color;
        int speed;
    
        // constructor
        OldVehicle(String type, String model, String color) {
            this.type = type;
            this.model = model;
            this.color = color;
        }
        
        // methods
        int increaseSpeed(int increment) {
            this.speed = this.speed + increment;
            return this.speed;
        }
        
        // ...
}





