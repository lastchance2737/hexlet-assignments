package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection connection;

    public Disconnected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        this.connection.setConnection(new Connected(this.connection));
    }

    @Override
    public void disconnect() {
        System.out.println("Try to disconnect when connection disconnected. Message must contains word Error");
    }

    @Override
    public void write(String data) {
        System.out.println("Try to write to disconnected connection. Message must contains word Error");
    }
}
// END
