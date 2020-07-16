package role;

import enums.RoleName;
import schedue.LogReplicationTask;

/**
 * leader角色
 * p62
 */
public class LeaderNodeRole extends AbstractNodeRole {
    /**
     * 日志复制定时器
     */
    private LogReplicationTask logReplicationTask;

    public LeaderNodeRole(int term, LogReplicationTask logReplicationTask) {
        super(RoleName.LEADER, term);
        this.logReplicationTask = logReplicationTask;
    }

    @Override
    public void cancelTimeoutOrTask() {
        this.logReplicationTask.cancel();
    }
}

