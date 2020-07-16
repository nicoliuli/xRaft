package bean;

/**
 * 节点信息
 */
public class NodeEndpoint {
    private final NodeId id;
    private final Address address;

    public NodeEndpoint(NodeId id, Address address) {
        this.id = id;
        this.address = address;
    }

    public NodeEndpoint(String id, String host, Integer part) {
        this(NodeId.of(id), new Address(host, part));
    }

    public NodeId getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
