package com.hytech;

import java.util.Random;

public class Test {

  public static void main(String[] args){
    for(int i = 0; i < 300; i++) {
      System.out.println(getFakeAccountNo());
    }
  }

  private static String getFakeAccountNo() {
    Random rand = new Random();
    // 分行代碼從 090 - 300
    int branchCode = rand.nextInt(90, 301);
    // 業務別代碼 2 碼
    int businessCategory = rand.nextInt(100);
    // 5 碼編號
    int serialNumber = rand.nextInt(100000);
    // 最後 1 碼為驗證碼
    int verificationCode = rand.nextInt(10);

    return String.format("%03d%02d%05d%d", branchCode, businessCategory, serialNumber, verificationCode);
  }
}
