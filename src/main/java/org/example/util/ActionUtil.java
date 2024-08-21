package org.example.util;

import java.util.Scanner;

public class ActionUtil {
    public static int getAction(int action) {
        while (true) {
            try {
                System.out.print("Enter action:  ");
                int n = new Scanner(System.in).nextInt();
                if (n <= action && 0 <= n ) {
                    return n;
                }
            } catch (Exception e) {

            }
        }
    }
}
