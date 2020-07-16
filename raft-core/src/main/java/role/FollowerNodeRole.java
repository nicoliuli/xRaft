package role;

import bean.NodeId;
import enums.RoleName;
import schedule.ElectionTimeout;

/**
 * Follower角色
 * p60
 */
public class FollowerNodeRole extends AbstractNodeRole {

    /**
     * 投过票的节点，有可能为空
     */
    private NodeId voteFor;
    /**
     * 当前leader的id，有可能为空
     */
    private NodeId leaderId;
    /**
     * 选举超时
     */
    private ElectionTimeout electionTimeout;


    public FollowerNodeRole(int term, NodeId voteFor, NodeId leaderId, ElectionTimeout electionTimeout) {
        super(RoleName.FOLLOWER, term);
        this.voteFor = voteFor;
        this.leaderId = leaderId;
        this.electionTimeout = electionTimeout;
    }

    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    public NodeId getVoteFor() {
        return voteFor;
    }

    public NodeId getLeaderId() {
        return leaderId;
    }

    @Override
    public String toString() {
        return "FollowerNodeRole{" +
                "voteFor=" + voteFor +
                ", leaderId=" + leaderId +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
