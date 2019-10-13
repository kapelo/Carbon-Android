package utility;

class ServerManager {
    private static String OS;
    private static String NODE_HOME;

    static String getNodeHome() {
        if (NODE_HOME == null) {
            NODE_HOME = System.getenv("NODE_HOME");
            if (NODE_HOME == null) throw new RuntimeException("NODE_HOME environment variable is not set");
        }
        return NODE_HOME;
    }
}