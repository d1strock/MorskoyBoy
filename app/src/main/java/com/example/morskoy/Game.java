package com.example.morskoy;

import android.widget.Toast;

import java.util.ArrayList;

public class Game {
    int n = 18;
    int m = 18;
    int flag = 0;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                battle1[i][j] = 0;
            }
        }
        while (!(ships.isEmpty())) {
            int s = 0;
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first && j == second && battle1[i][j] != 1) {
                        if (battle1[i - 1][j] == 0 && battle1[i + 1][j] == 0 && battle1[i][j - 1] == 0
                                && battle1[i][j + 1] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j - 1] == 0
                                && battle1[i + 1][j - 1] == 0 && battle1[i - 1][j + 1] == 0) {
                            battle1[i][j] = 1;
                            ships.remove(s);
                        }
                    }
                }
            }
        }
        ships.add(1);
        ships.add(1);
        ships.add(1);
        while (!(ships.isEmpty())) {
            int s = 0;
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first && j == second && battle1[i][j] != 1) {
                        if (battle1[i][j + 1] == 0 && battle1[i][j - 1] == 0 && battle1[i - 1][j] == 0
                                && battle1[i + 1][j] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i + 1][j - 1] == 0
                                && battle1[i][j + 2] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i - 1][j + 2] == 0 && battle1[i + 1][j + 2] == 0) {
                            battle1[i][j] = 1;
                            battle1[i][j + 1] = 1;
                            ships.remove(s);
                        }
                    }
                }
            }
        }
        ships.add(1);
        ships.add(1);
        while (!(ships.isEmpty())) {
            int s = 0;
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first && j == second && battle1[i][j] != 1) {
                        if (battle1[i][j + 1] == 0 && battle1[i][j + 2] == 0 && battle1[i][j + 3] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i + 1][j - 1] == 0
                                && battle1[i - 1][j] == 0 && battle1[i + 1][j] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j + 2] == 0 && battle1[i + 1][j + 2] == 0
                                && battle1[i - 1][j + 3] == 0 && battle1[i + 1][j + 3] == 0) {
                            battle1[i][j] = 1;
                            battle1[i][j + 1] = 1;
                            battle1[i][j + 2] = 1;
                            ships.remove(s);
                        }
                    }
                }
            }
        }
        ships.add(1);
        while (!(ships.isEmpty())) {
            int s = 0;
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first && j == second && battle1[i][j] != 1) {
                        if (battle1[i][j + 1] == 0 && battle1[i][j + 2] == 0 && battle1[i][j + 3] == 0 && battle1[i][j + 4] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i - 1][j] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i - 1][j + 2] == 0 && battle1[i - 1][j + 3] == 0 && battle1[i - 1][j + 4] == 0
                                && battle1[i + 1][j - 1] == 0 && battle1[i + 1][j] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i + 1][j + 2] == 0
                                && battle1[i + 1][j + 3] == 0 && battle1[i + 1][j + 4] == 0) {
                            battle1[i][j] = 1;
                            battle1[i][j + 1] = 1;
                            battle1[i][j + 2] = 1;
                            battle1[i][j + 3] = 1;
                            ships.remove(s);
                        }
                    }
                }
            }
        }
    }

    void fixingCoordinatesOne() {
        if (battle[firstEdLetter - 1][firstEdNumber] == 0 && battle[firstEdLetter + 1][firstEdNumber] == 0 && battle[firstEdLetter][firstEdNumber - 1] == 0
                && battle[firstEdLetter][firstEdNumber + 1] == 0 && battle[firstEdLetter + 1][firstEdNumber + 1] == 0 && battle[firstEdLetter - 1][firstEdNumber - 1] == 0
                && battle[firstEdLetter + 1][firstEdNumber - 1] == 0 && battle[firstEdLetter - 1][firstEdNumber + 1] == 0) {
            battle[firstEdLetter][firstEdNumber] = 1;
            flag = 1;
        }
        else flag = 2;
    }
    void fixingCoordinatesTwo() {
        if (secondEdLetter - firstEdLetter == 1 && firstEdNumber == secondEdNumber) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber] == 0
                    && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0 && battle[firstEdLetter][firstEdNumber-1] == 0
                    && battle[firstEdLetter][firstEdNumber+1] == 0 && battle[secondEdLetter+1][secondEdNumber] == 0 && battle[secondEdLetter+1][secondEdNumber-1] == 0
                    && battle[secondEdLetter+1][secondEdNumber+1] == 0 && battle[secondEdLetter][secondEdNumber-1] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                flag = 1;
            }
            else flag = 2;
        } else if (secondEdNumber - firstEdNumber == 1 && firstEdLetter == secondEdLetter) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter][firstEdNumber-1] == 0
                    && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter+1][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber] == 0
                    && battle[firstEdLetter+1][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0 && battle[secondEdLetter+1][secondEdNumber+1] == 0
                    && battle[secondEdLetter-1][secondEdNumber+1] == 0 && battle[secondEdLetter+1][secondEdNumber] == 0 && battle[secondEdLetter-1][secondEdNumber] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                flag = 1;
            }
            else flag = 2;
        } else flag = 2;
    }
    void fixingCoordinatesThree() {
        if (secondEdLetter - firstEdLetter == 2 && firstEdNumber == secondEdNumber) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter+1][firstEdNumber] == 0
                    && battle[firstEdLetter-1][firstEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0
                    && battle[firstEdLetter][firstEdNumber-1] == 0 && battle[firstEdLetter][firstEdNumber+1] == 0 && battle[firstEdLetter+1][firstEdNumber-1] == 0
                    && battle[firstEdLetter+1][firstEdNumber+1] == 0 && battle[secondEdLetter][secondEdNumber-1] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0
                    && battle[secondEdLetter+1][secondEdNumber] == 0 && battle[secondEdLetter+1][secondEdNumber-1] == 0 && battle[secondEdLetter+1][secondEdNumber+1] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                battle[firstEdLetter + 1][firstEdNumber] = 1;
                flag = 1;
            }
            else flag = 2;
        } else if (secondEdNumber - firstEdNumber == 2 && firstEdLetter == secondEdLetter) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter][firstEdNumber+1] == 0
                    && battle[firstEdLetter][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter+1][firstEdNumber-1] == 0
                    && battle[firstEdLetter-1][firstEdNumber] == 0 && battle[firstEdLetter+1][firstEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0
                    && battle[firstEdLetter+1][firstEdNumber+1] == 0 && battle[secondEdLetter-1][secondEdNumber] == 0 && battle[secondEdLetter+1][secondEdNumber] == 0
                    && battle[secondEdLetter-1][secondEdNumber+1] == 0 && battle[secondEdLetter+1][secondEdNumber+1] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                battle[firstEdLetter][firstEdNumber + 1] = 1;
                flag = 1;
            }
            else flag = 2;
        }
        else flag = 2;
    }
    void fixingCoordinatesFour() {
        if (secondEdLetter - firstEdLetter == 3 && firstEdNumber == secondEdNumber) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter+1][firstEdNumber] == 0
                    && battle[firstEdLetter+2][firstEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter+1][firstEdNumber-1] == 0
                    && battle[firstEdLetter][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0
                    && battle[firstEdLetter+1][firstEdNumber+1] == 0 && battle[firstEdLetter][firstEdNumber+1] == 0 && battle[secondEdLetter+1][secondEdNumber] == 0
                    && battle[secondEdLetter+1][secondEdNumber-1] == 0 && battle[secondEdLetter+1][secondEdNumber+1] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0
                    && battle[secondEdLetter][secondEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                battle[firstEdLetter + 1][firstEdNumber] = 1;
                battle[firstEdLetter + 2][firstEdNumber] = 1;
                flag = 1;
            }
            else flag = 2;
        } else if (secondEdNumber - firstEdNumber == 3 && firstEdLetter == secondEdLetter) {
            if (battle[firstEdLetter][firstEdNumber] == 0 && battle[secondEdLetter][secondEdNumber] == 0 && battle[firstEdLetter][firstEdNumber+1] == 0
                    && battle[firstEdLetter][firstEdNumber+2] == 0 && battle[firstEdLetter-1][firstEdNumber+1] == 0 && battle[firstEdLetter-1][firstEdNumber] == 0
                    && battle[firstEdLetter-1][firstEdNumber-1] == 0 && battle[firstEdLetter][firstEdNumber-1] == 0 && battle[firstEdLetter+1][firstEdNumber-1] == 0
                    && battle[firstEdLetter+1][firstEdNumber] == 0 && battle[firstEdLetter+1][firstEdNumber+1] == 0 && battle[secondEdLetter-1][secondEdNumber-1] == 0
                    && battle[secondEdLetter-1][secondEdNumber] == 0 && battle[secondEdLetter-1][secondEdNumber+1] == 0 && battle[secondEdLetter][secondEdNumber+1] == 0
                    && battle[secondEdLetter+1][secondEdNumber+1] == 0 && battle[firstEdLetter+1][firstEdNumber] == 0 && battle[firstEdLetter-1][firstEdNumber-1] == 0) {
                battle[firstEdLetter][firstEdNumber] = 1;
                battle[secondEdLetter][secondEdNumber] = 1;
                battle[firstEdLetter][firstEdNumber + 1] = 1;
                battle[firstEdLetter][firstEdNumber + 2] = 1;
                flag = 1;
            }
            else flag = 2;
        }
        else flag = 2;
    }

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
