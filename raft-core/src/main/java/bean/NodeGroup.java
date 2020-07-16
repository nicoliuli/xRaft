package bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 集群成员表
 */
public class NodeGroup {
    private NodeId selfId;
    private Map<NodeId, GroupMember> memberMap;

    NodeGroup(Collection<NodeEndpoint> endpoints, NodeId selfId) {
        this.selfId = selfId;

    }

    private Map<NodeId, GroupMember> buildMemberMap(Collection<NodeEndpoint> endpoints) {
        Map<NodeId, GroupMember> map = new HashMap<NodeId, GroupMember>();
        for (NodeEndpoint endpoint : endpoints) {
            map.put(endpoint.getId(), new GroupMember(endpoint));
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException("endpoints is empty");
        }
        return map;
    }

    GroupMember findMember(NodeId id) {
        GroupMember member = this.getMember(id);
        if (member == null) {
            throw new IllegalArgumentException("no such node " + id);
        }
        return member;
    }

    GroupMember getMember(NodeId id) {
        return memberMap.get(id);
    }


}
