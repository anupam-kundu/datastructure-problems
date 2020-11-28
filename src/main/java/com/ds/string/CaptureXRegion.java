package com.ds.string;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * X X X X         X X X X
 * X O O X   --->  X X X X
 * X X O X         X X X X
 * X O X X         X O X X
 */
public class CaptureXRegion {
    private List<Map.Entry<Integer, Integer>> locationsOfO = new ArrayList<>();
    private char[][] chArr = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };

    private void populateLocations(int i, int j) {
        if (i < 0 || j < 0 || i >= chArr.length || j >= chArr[0].length) {
            return;
        }
        char element = chArr[i][j];
        Map.Entry location = new AbstractMap.SimpleEntry(i, j);

        if (element != 'O' || locationsOfO.contains(location)) {
            return;
        }
        locationsOfO.add(location);
//        populateLocations(i - 1, j - 1);
        populateLocations(i - 1, j);
//        populateLocations(i - 1, j + 1);
        populateLocations(i + 1, j);
//        populateLocations(i + 1, j + 1);
//        populateLocations(i + 1, j - 1);
        populateLocations(i, j - 1);
        populateLocations(i, j + 1);
    }

    private void traverseBoundary() {
        for (int i = 0; i < chArr.length; i++) {
            populateLocations(i, 0);
            populateLocations(i, chArr[0].length-1);
        }
        for (int i = 0; i < chArr[0].length; i++) {
            populateLocations(0, i);
            populateLocations(chArr.length-1, i);
        }
    }

    public static void main(String[] args) {
        CaptureXRegion region = new CaptureXRegion();
        region.traverseBoundary();
        System.out.println(region.locationsOfO);
    }
}
