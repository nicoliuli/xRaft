package bean;

import java.io.Serializable;
import java.util.Objects;

public class NodeId implements Serializable {
    private final String value;

    public NodeId(String value) {
        this.value = value;
    }

    public static NodeId of(String value) {
        return new NodeId(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NodeId)) {
            return false;
        }
        NodeId id = (NodeId) obj;
        return Objects.equals(this.value, id.getValue());
    }

    @Override
    public String toString() {
        return this.value;
    }
}
