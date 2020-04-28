import Database.Connect;

public class Main {
    public static void main(String[] args) {
        try {
            Connect.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
