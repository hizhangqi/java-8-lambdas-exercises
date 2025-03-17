package com.systeminfos.leetcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProofOfWorkDemo {
    private static final int DIFFICULTY = 5; // 难度级别，要求哈希前5位是0

    public static void main(String[] args) {
        String data = "Hello, PoW!"; // 交易或区块数据
        int nonce = 0; // 计数器
        String hash;

        long startTime = System.currentTimeMillis();
        
        // 反复尝试不同的 Nonce 值，直到找到符合条件的哈希值
        do {
            hash = sha256(data + nonce);
            nonce++;
        } while (!hash.startsWith(String.format("%0" + DIFFICULTY + "d", 0)));

        long endTime = System.currentTimeMillis();
d
        System.out.println("✅ 挖矿成功！");
        System.out.println("⛏️ 计算次数: " + nonce);
        System.out.println("🔑 找到哈希: " + hash);
        System.out.println("⏳ 用时: " + (endTime - startTime) + " 毫秒");
    }

    // 计算 SHA-256 哈希
    private static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 算法不可用", e);
        }
    }
}