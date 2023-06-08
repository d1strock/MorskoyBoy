package com.example.morskoy;

import android.widget.Toast;

import java.util.ArrayList;

public class Game {
    int countVictoryBot;
    int countVictoryPlayer;
    int n = 18;
    int m = 18;
    int flag = 0;
    boolean time;
    int opr[][] = new int[n][m];
    int battle[][] = new int[n][m];
    int battle1[][] = new int[n][m];
    int firstEdNumber, secondEdNumber, firstEdLetter, secondEdLetter, helpLetter1, helpLetter2;
    int x = 140;
    int y = 125;
    int kl = 75;
    Method method;
    ArrayList<String> letters = new ArrayList<>();

    ArrayList<Integer> shipsOne = new ArrayList<>();
    ArrayList<Integer> shipsTwo = new ArrayList<>();
    ArrayList<Integer> shipsThree = new ArrayList<>();
    ArrayList<Integer> shipsFour = new ArrayList<>();

    int first;
    int second;
    void tryOne() {
        shipsOne.add(1);
        shipsOne.add(1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                battle1[i][j] = 1;
            }
        }
        for (int i = 4; i < n-4; i++) {
            for (int j = 4; j < m-4; j++) {
                battle1[i][j] = 0;
            }
        }
        while (!(shipsOne.isEmpty())) {
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first+3 && j == second+3 && battle1[i][j] != 3) {
                        if (battle1[i - 1][j] == 0 && battle1[i + 1][j] == 0 && battle1[i][j - 1] == 0
                                && battle1[i][j + 1] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j - 1] == 0
                                && battle1[i + 1][j - 1] == 0 && battle1[i - 1][j + 1] == 0) {
                            battle1[i][j] = 3;
                            shipsOne.remove(0);
                        }
                    }
                }
            }
        }
    }
    void tryTwo() {
        shipsTwo.add(1);
        shipsTwo.add(1);
        while (!(shipsTwo.isEmpty())) {
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first+3 && j == second+3 && battle1[i][j] != 3) {
                        if (battle1[i][j + 1] == 0 && battle1[i][j - 1] == 0 && battle1[i - 1][j] == 0
                                && battle1[i + 1][j] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i + 1][j - 1] == 0
                                && battle1[i][j + 2] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i - 1][j + 2] == 0 && battle1[i + 1][j + 2] == 0) {
                            battle1[i][j] = 3;
                            battle1[i][j + 1] = 3;
                            shipsTwo.remove(0);
                        } else if (battle1[i+1][j] == 0 && battle1[i][j - 1] == 0 && battle1[i - 1][j-1] == 0
                                && battle1[i - 1][j] == 0 && battle1[i - 1][j + 1] == 0 && battle1[i][j + 1] == 0
                                && battle1[i+1][j-1] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i+2][j - 1] == 0
                                && battle1[i + 2][j] == 0 && battle1[i + 2][j + 1] == 0) {
                            battle1[i][j] = 3;
                            battle1[i+1][j] = 3;
                            shipsTwo.remove(0);
                        }
                    }
                }
            }
        }
    }
    void tryThree() {
        shipsThree.add(1);
        shipsThree.add(1);
        while (!(shipsThree.isEmpty())) {
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first+3 && j == second+3 && battle1[i][j] != 3) {
                        if (battle1[i+1][j] == 0 && battle1[i+2][j] == 0 && battle1[i+1][j-1] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i - 1][j] == 0
                                && battle1[i - 1][j+1] == 0 && battle1[i][j+1] == 0 && battle1[i + 1][j + 1] == 0
                                && battle1[i + 2][j - 1] == 0 && battle1[i + 3][j - 1] == 0 && battle1[i + 3][j] == 0
                                && battle1[i+3][j + 1] == 0 && battle1[i + 2][j + 1] == 0) {
                            battle1[i][j] = 3;
                            battle1[i+1][j] = 3;
                            battle1[i+2][j] = 3;
                            shipsThree.remove(0);
                        }
                        else if (battle1[i][j + 1] == 0 && battle1[i][j + 2] == 0 && battle1[i][j + 3] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i + 1][j - 1] == 0
                                && battle1[i - 1][j] == 0 && battle1[i + 1][j] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i + 1][j + 1] == 0 && battle1[i - 1][j + 2] == 0 && battle1[i + 1][j + 2] == 0
                                && battle1[i - 1][j + 3] == 0 && battle1[i + 1][j + 3] == 0) {
                            battle1[i][j] = 3;
                            battle1[i][j + 1] = 3;
                            battle1[i][j + 2] = 3;
                            shipsThree.remove(0);
                        }
                    }
                }
            }
        }
    }
    void tryFour() {
        shipsFour.add(1);
        while (!(shipsFour.isEmpty())) {
            first = (int) (1 + Math.random() * 10);
            second = (int) (1 + Math.random() * 10);
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first+3 && j == second+3 && battle1[i][j] != 3) {
                        if (battle1[i][j + 1] == 0 && battle1[i][j + 2] == 0 && battle1[i][j + 3] == 0 && battle1[i][j + 4] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i - 1][j] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i - 1][j + 2] == 0 && battle1[i - 1][j + 3] == 0 && battle1[i - 1][j + 4] == 0
                                && battle1[i + 1][j - 1] == 0 && battle1[i + 1][j] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i + 1][j + 2] == 0
                                && battle1[i + 1][j + 3] == 0 && battle1[i + 1][j + 4] == 0) {
                            battle1[i][j] = 3;
                            battle1[i][j + 1] = 3;
                            battle1[i][j + 2] = 3;
                            battle1[i][j + 3] = 3;
                            shipsFour.remove(0);
                        }
                        else if (battle1[i+1][j] == 0 && battle1[i+2][j] == 0 && battle1[i+3][j] == 0 && battle1[i+1][j-1] == 0
                                && battle1[i][j - 1] == 0 && battle1[i - 1][j - 1] == 0 && battle1[i - 1][j] == 0 && battle1[i - 1][j + 1] == 0
                                && battle1[i][j + 1] == 0 && battle1[i + 1][j + 1] == 0 && battle1[i + 2][j - 1] == 0
                                && battle1[i + 3][j - 1] == 0 && battle1[i + 4][j-1] == 0 && battle1[i + 4][j] == 0 && battle1[i + 4][j + 1] == 0
                                && battle1[i + 3][j + 1] == 0 && battle1[i + 2][j + 1] == 0) {
                            battle1[i][j] = 3;
                            battle1[i+1][j] = 3;
                            battle1[i+2][j] = 3;
                            battle1[i+3][j] = 3;
                            shipsFour.remove(0);
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
    void botShoot() {
        first = 4 + (int)(Math.random() * 10);
        second = 4 + (int)(Math.random() * 10);
        if (time == false) {
            for (int i = 4; i < n - 4; i++) {
                for (int j = 4; j < m - 4; j++) {
                    if (i == first && j == second) {
                        if (battle[first][second] == 1) {
                            battle[i][j] = 3;
                            break;
                        } else if (battle[first][second] == 0) {
                            battle[i][j] = 2;
                            break;
                        }
                        else if (battle[first][second] == 2) {
                            battle[i][j] = 2;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 4; i < n - 4; i++) {
            for (int j = 4; j < m - 4; j++) {
                if (battle[i][j] == 1) {
                    countVictoryBot++;
                }
            }
        }
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
