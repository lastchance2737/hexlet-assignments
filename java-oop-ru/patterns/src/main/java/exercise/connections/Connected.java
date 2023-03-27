package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection connection;

    public Connected(TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Try to connect when connection already established. Message must contains word Error");
    }

    @Override
    public void disconnect() {
        this.connection.setConnection(new Disconnected(this.connection));
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
// END
