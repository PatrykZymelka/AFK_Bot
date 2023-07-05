public class GUIActionPerformer {
    public int TimeConversion(String Time){
        switch (Time) {
            case "2 minutes":
                return (2 * 60 * 1000);
            case "1 minute":
                return (60 * 1000);
            case "15 seconds":
                return (15 * 1000);
            case "1 second":
                return (1000);
            default:
                return (30 * 1000);
        }
    }
    public String MethodConversion(String Method){
        switch (Method) {
            case "Jump":
                return "J";
            case "Left Click":
                return "L";
            case "WASD":
                return "W";
            case "Random":
                return "R";
            default:
                return "J";
        }
    }

}
