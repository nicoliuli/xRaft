package bean;

/**
 * 集群成员信息
 */
public class GroupMember {
    private NodeEndpoint endpoint;
    private ReplicatingState replicatingState;

    // 无日志复制状态的构造函数
    public GroupMember(NodeEndpoint endpoint, ReplicatingState replicatingState) {
        this.endpoint = endpoint;
        this.replicatingState = replicatingState;
    }

    // 有日志复制状态的构造函数
    public GroupMember(NodeEndpoint endpoint) {
        this(endpoint, null);
    }

    public NodeEndpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(NodeEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    public ReplicatingState getReplicatingState() {
        return replicatingState;
    }

    public void setReplicatingState(ReplicatingState replicatingState) {
        this.replicatingState = replicatingState;
    }

    // 获取nextIndex
    int getNextIndex() {
        return this.replicatingState.getNextIndex();
    }

    // 获取matchIndex
    int getMatchIndex() {
        return this.replicatingState.getMatchIndex();
    }
}
