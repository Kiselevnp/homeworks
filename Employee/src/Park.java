public class Park {
    private String name;
        public Park(String name) {
        this.name = name;
    }
    private class Attractions {
        private String attractionName;
        private String operationTime;
        private double cost;
        private Attractions (String attractionName, String operationTime, double cost){
            this.attractionName = attractionName;
            this.operationTime = operationTime;
            this.cost = cost;}
    }
    public void addAttraction(String attractionName, String operationTime, double cost) {
        Attractions attraction = new Attractions(attractionName, operationTime, cost);
    }

}

