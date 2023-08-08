package com.systeminfos.cap;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个 Paxos 类有三个方法：
 * propose(int value)：向所有接受者提议一个值。它首先生成一个提议号，然后向所有接受者发送一个包含提议号和值的消息。接受者会根据提议号和值来更新它们的状态，如果它们的提议号比当前的提议号更高，那么它们会更新自己的提议号和值。
 * receiveProposal(int proposalNumber, int value)：当一个接受者收到一个提议时，它会调用这个方法来处理它。如果接受者的提议号比当前的提议号更高，那么它会更新自己的提议号和值。
 * getHighestProposalNumber() 和 getHighestProposalValue()：这些方法用于获取当前的提议号和值。
 * 这个示例代码只是一个简单的实现，实际上 Paxos 算法需要更复杂的实现来保证正确性和容错性。
 */
public class Paxos {
    private final int id;
    private final List<Paxos> acceptors;
    private int highestProposalNumber;
    private int highestProposalValue;

    public Paxos(int id, List<Paxos> acceptors) {
        this.id = id;
        this.acceptors = acceptors;
        this.highestProposalNumber = 0;
        this.highestProposalValue = 0;
    }

    public void propose(int value) {
        int proposalNumber = highestProposalNumber + 1;
        for (Paxos acceptor : acceptors) {
            acceptor.receiveProposal(proposalNumber, value);
        }
        highestProposalNumber = proposalNumber;
        highestProposalValue = value;
    }

    public void receiveProposal(int proposalNumber, int value) {
        if (proposalNumber > highestProposalNumber) {
            highestProposalNumber = proposalNumber;
            highestProposalValue = value;
        }
    }

    public int getHighestProposalNumber() {
        return highestProposalNumber;
    }

    public int getHighestProposalValue() {
        return highestProposalValue;
    }


}
