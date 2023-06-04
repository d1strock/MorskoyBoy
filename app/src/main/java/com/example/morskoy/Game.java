package com.example.morskoy;

import java.util.ArrayList;

public class Game {
    int n = 18;
    int m = 18;
    int battle[][] = new int[n][m];
    int battle1[][] = new int[n][m];
    int firstEdNumber, secondEdNumber, firstEdLetter, secondEdLetter, helpLetter1, helpLetter2;
    int x = 140;
    int y = 200;
    int kl = 75;
    ArrayList<Integer> ships = new ArrayList<>();
    int first;
    int second;
    void try1() {
        ships.add(1);
        ships.add(1);
        ships.add(1);
        ships.add(1);
        ships.add(2);
        ships.add(2);
        ships.add(2);
        ships.add(3);
        ships.add(3);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                battle1[i][j] = 0;
            }
        }
        while (!(ships.isEmpty())) {
            for (int s = 0; s < ships.size(); s++) {
                first = (int) (1 + Math.random() * 10);
                second = (int) (1 + Math.random() * 10);
                for (int i = 4; i < n - 4; i++) {
                    for (int j = 4; j < m - 4; j++) {
                        if (i == first && j == second && battle1[i][j] != 1) {
                            if (ships.get(s).equals(1)) {
                                if (battle1[i-1][j] == 0 && battle1[i+1][j] == 0 && battle1[i][j-1] == 0 && battle1[i][j+1] == 0 && battle1[i+1][j+1] == 0 && battle1[i-1][j-1] == 0 && battle1[i+1][j-1] == 0 && battle1[i-1][j+1] == 0) {
                                    battle1[i][j] = 1;
                                    ships.remove(s);
                                }
                            } else if (ships.get(s).equals(2)) {
                                if (battle1[i][j+1] == 0 && battle1[i][j-1] == 0 && battle1[i-1][j] == 0 && battle1[i+1][j] == 0 && battle1[i-1][j-1] == 0 && battle1[i+1][j-1] == 0 && battle1[i][j+2] == 0 && battle1[i+1][j+1] == 0 && battle1[i-1][j+1] == 0 && battle1[i-1][j+2] == 0 && battle1[i+1][j+2] == 0) {
                                    battle1[i][j] = 1;
                                    battle1[i][j+1] = 1;
                                    ships.remove(s);
                                }
                            } else if (ships.get(s).equals(3)) {
                                if (battle1[i][j+1] == 0 && battle1[i][j+2] == 0 && battle1[i][j+3] == 0 && battle1[i][j-1] == 0 && battle1[i-1][j-1] == 0 && battle1[i+1][j-1] == 0 && battle1[i-1][j] == 0 && battle1[i+1][j] == 0 && battle1[i-1][j+1] == 0 && battle1[i+1][j+1] == 0 && battle1[i-1][j+2] == 0 && battle1[i+1][j+2] == 0 && battle1[i-1][j+3] == 0 && battle1[i+1][j+3] == 0) {
                                    battle1[i][j] = 1;
                                    battle1[i][j+1] = 1;
                                    battle1[i][j+2] = 1;
                                    ships.remove(s);
                                }
                            }
                        }
                    }
                }
            }
        }
//        ships.add(1);
//        ships.add(1);
//        ships.add(1);
//        while (!(ships.isEmpty())) {
//            for (int s = 0; s < ships.size(); s++) {
//                first = (int) (1 + Math.random() * 10);
//                second = (int) (1 + Math.random() * 10);
//                for (int i = 4; i < n - 4; i++) {
//                    for (int j = 4; j < m - 4; j++) {
//                        if (i == first && j == second && battle1[i][j] != 1) {
//                            if (battle1[i][j+1] == 0 && battle1[i][j-1] == 0 && battle1[i-1][j] == 0 && battle1[i+1][j] == 0 && battle1[i-1][j-1] == 0 && battle1[i+1][j-1] == 0 && battle1[i][j+2] == 0 && battle1[i+1][j+1] == 0 && battle1[i-1][j+1] == 0 && battle1[i-1][j+2] == 0 && battle1[i+1][j+2] == 0) {
//                                battle1[i][j] = 1;
//                                battle1[i][j+1] = 1;
//                                ships.remove(s);
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
    void fixingCoordinates() {}
    void definitionLetter(String letters) {
        switch (letters) {
            case "А":
            case "а":
                helpLetter1 = 1;
                helpLetter2 = 1;
                break;
            case "Б":
            case "б":
                helpLetter1 = 2;
                helpLetter2 = 2;
                break;
            case "В":
            case "в":
                helpLetter1 = 3;
                helpLetter2 = 3;
                break;
            case "Г":
            case "г":
                helpLetter1 = 4;
                helpLetter2 = 4;
                break;
            case "Д":
            case "д":
                helpLetter1 = 5;
                helpLetter2 = 5;
                break;
            case "Е":
            case "е":
                helpLetter1 = 6;
                helpLetter2 = 6;
                break;
            case "Ж":
            case "ж":
                helpLetter1 = 7;
                helpLetter2 = 7;
                break;
            case "З":
            case "з":
                helpLetter1 = 8;
                helpLetter2 = 8;
                break;
            case "И":
            case "и":
                helpLetter1 = 9;
                helpLetter2 = 9;
                break;
            case "К":
            case "к":
                helpLetter1 = 10;
                helpLetter2 = 10;
                break;
            default:
                helpLetter1 = -1;
                helpLetter2 = -1;
        }
    }
}
