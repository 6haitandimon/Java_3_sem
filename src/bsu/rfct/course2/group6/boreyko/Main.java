package bsu.rfct.course2.group6.boreyko;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double[] a = {1., 5., 4., 3., 2., 1.};

        HornersScheme frame = new HornersScheme(a);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}