package role;

import enums.RoleName;
import schedule.ElectionTimeout;

/**
 * 被选举者
 * p61
 */
public class CandidateNodeRole extends AbstractNodeRole {
    private int votesCounts;
    private ElectionTimeout electionTimeout;

    /**
     * 构造函数，票数为1
     *
     * @param term
     * @param electionTimeout
     */
    public CandidateNodeRole(int term, ElectionTimeout electionTimeout) {
        this(term, 1, electionTimeout);
    }

    /**
     * 构造函数，可指定票数
     *
     * @param term
     * @param votesCounts
     * @param electionTimeout
     */
    public CandidateNodeRole(int term, int votesCounts, ElectionTimeout electionTimeout) {
        super(RoleName.CANDIDATE, term);
        this.votesCounts = votesCounts;
        this.electionTimeout = electionTimeout;
    }

    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    /**
     * 增加一个票数
     *
     * @param electionTimeout
     * @return
     */
    public CandidateNodeRole increaseVotesCount(ElectionTimeout electionTimeout) {
        // 增加票数也就意味着选举超时
        this.electionTimeout.cancel();
        return new CandidateNodeRole(term, votesCounts + 1, electionTimeout);
    }

    public int getVotesCounts() {
        return votesCounts;
    }


    @Override
    public String toString() {
        return "CandidateNodeRole{" +
                "votesCounts=" + votesCounts +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
