public class Car {
        private int vehicle_serial_number;
        private String name;
        private String model;
        private int year;
        private String manufacturer;
        private int basecost;

        public Car (int vehicle_serial_number, String name, String model, int year, String manufacturer, int basecost) {
            this.vehicle_serial_number = vehicle_serial_number;
            this.name = name;
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.basecost = basecost;
        }

        //Get method
        public int getVehicle_serial_number(){
            return vehicle_serial_number;
        }
        public String getName(){
            return name;
        }
        public String getModel(){
            return model;
        }
        public int getYear(){
            return year;
        }
        public String getManufacturer(){
            return manufacturer;
        }
        public int getBasecost(){
            return basecost;
        }
}

