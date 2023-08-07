package com.systeminfos.cap;

import java.util.HashMap;
import java.util.Map;

class PaxosNode {
    private int nodeId;
    private Map<Integer, String> proposedValues;
    private int highestProposalNumber;
    private String acceptedValue;

    public PaxosNode(int nodeId) {
        this.nodeId = nodeId;
        this.proposedValues = new HashMap<>();
        this.highestProposalNumber = -1;
        this.acceptedValue = null;
    }

    public void prepare(int proposalNumber) {
        if (proposalNumber > highestProposalNumber) {
            highestProposalNumber = proposalNumber;
            sendMessageToAll("Prepare", proposalNumber);
        }
    }

    public void receivePrepareResponse(int fromNodeId, int proposalNumber, String value) {
        if (proposalNumber == highestProposalNumber) {
            proposedValues.put(fromNodeId, value);
            if (proposedValues.size() > (nodeId / 2)) {
                String maxValue = null;
                for (String v : proposedValues.values()) {
                    if (maxValue == null || v.compareTo(maxValue) > 0) {
                        maxValue = v;
                    }
                }
                acceptedValue = maxValue;
                sendMessageToAll("Accept", proposalNumber, acceptedValue);
            }
        }
    }

    public void receiveAcceptResponse(int fromNodeId, int proposalNumber) {
        if (proposalNumber == highestProposalNumber) {
            sendMessageToAll("Decide", proposalNumber, acceptedValue);
        }
    }

    private void sendMessageToAll(String messageType, int proposalNumber) {
        // Simulate sending messages to all nodes
    }

    private void sendMessageToAll(String messageType, int proposalNumber, String value) {
        // Simulate sending messages to all nodes
    }
}

public class Main {
    public static void main(String[] args) {
        PaxosNode node1 = new PaxosNode(1);
        PaxosNode node2 = new PaxosNode(2);
        PaxosNode node3 = new PaxosNode(3);

        node1.prepare(1);
        node2.prepare(2);
        node3.prepare(3);
    }
}
