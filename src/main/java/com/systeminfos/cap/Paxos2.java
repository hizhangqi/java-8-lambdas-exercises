package com.systeminfos.cap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Paxos2 {
    private int nodeId;
    private Map<Integer, Proposal> proposals = new HashMap<>();
    private Set<Integer> acceptedProposals = new HashSet<>();

    public Paxos2(int nodeId) {
        this.nodeId = nodeId;
    }

    public void propose(int proposalId, int value) {
        Proposal proposal = new Proposal(proposalId, value);
        proposals.put(proposalId, proposal);
        // Send prepare messages to all nodes
        for (int i = 0; i < 3; i++) {
            Message prepareMessage = new Message(MessageType.PREPARE, nodeId, proposalId);
            sendMessage(prepareMessage, i);
        }
    }

    public void receiveMessage(Message message) {
        switch (message.getType()) {
            case PREPARE:
                // Check if we have already accepted a proposal with a higher ID
                if (acceptedProposals.contains(message.getProposalId())) {
                    Proposal acceptedProposal = proposals.get(message.getProposalId());
                    Message responseMessage = new Message(MessageType.RESPONSE, nodeId, message.getProposalId(), acceptedProposal.getValue());
                    sendMessage(responseMessage, message.getNodeId());
                } else {
                    acceptedProposals.add(message.getProposalId());
                    Message responseMessage = new Message(MessageType.ACCEPT, nodeId, message.getProposalId(), proposals.get(message.getProposalId()).getValue());
                    sendMessage(responseMessage, message.getNodeId());
                }
                break;
            case ACCEPT:
                // Check if we have already accepted a proposal with a higher ID
                if (acceptedProposals.contains(message.getProposalId())) {
                    Proposal acceptedProposal = proposals.get(message.getProposalId());
                    Message responseMessage = new Message(MessageType.RESPONSE, nodeId, message.getProposalId(), acceptedProposal.getValue());
                    sendMessage(responseMessage, message.getNodeId());
                } else {
                    acceptedProposals.add(message.getProposalId());
                    Message responseMessage = new Message(MessageType.COMMIT, nodeId, message.getProposalId(), proposals.get(message.getProposalId()).getValue());
                    sendMessage(responseMessage, message.getNodeId());
                }
                break;
            case RESPONSE:
                // Update our proposal with the accepted value
                Proposal proposal = proposals.get(message.getProposalId());
                proposal.setValue(message.getValue());
                break;
            case COMMIT:
                // Update our state with the accepted value
                Proposal committedProposal = proposals.get(message.getProposalId());
                System.out.println("Node " + nodeId + " committed value " + committedProposal.getValue());
                break;
        }
    }

    private void sendMessage(Message message, int nodeId) {
        // Send message to node with ID nodeId
    }

    private enum MessageType {PREPARE, ACCEPT, RESPONSE, COMMIT}

    private static class Message {
        private MessageType type;
        private int nodeId;
        private int proposalId;
        private int value;

        public Message(MessageType type, int nodeId, int proposalId, int value) {
            this.type = type;
            this.nodeId = nodeId;
            this.proposalId = proposalId;
            this.value = value;
        }

        public Message(MessageType type, int nodeId, int proposalId) {
            this(type, nodeId, proposalId, 0);
        }

        public MessageType getType() {
            return type;
        }

        public int getNodeId() {
            return nodeId;
        }

        public int getProposalId() {
            return proposalId;
        }

        public int getValue() {
            return value;
        }
    }

    private static class Proposal {
        private int proposalId;
        private int value;

        public Proposal(int proposalId, int value) {
            this.proposalId = proposalId;
            this.value = value;
        }

        public int getProposalId() {
            return proposalId;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}