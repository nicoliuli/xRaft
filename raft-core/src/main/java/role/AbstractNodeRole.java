package role;

import enums.RoleName;

/**
 * 角色抽象类
 * p59
 */
abstract class AbstractNodeRole {
    /**
     * 角色
     */
    private RoleName roleName;
    /**
     * 票数
     */
    protected int term;

    /**
     * 取消超时或定时任务
     */
    public abstract void cancelTimeoutOrTask();

    public AbstractNodeRole(RoleName roleName, int term) {
        this.roleName = roleName;
        this.term = term;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public int getTerm() {
        return term;
    }

}
