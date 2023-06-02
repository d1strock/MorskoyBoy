package com.example.morskoy;

public class Game {
    int n = 11;
    int m = 11;
    int battle[][] = new int[n][m];
//    int left = 170;
//    int right = 240;
//    int top = 200;
//    int bottom = 130;
    int firstEdNumber, secondEdNumber, firstEdLetter, secondEdLetter, helpLetter1, helpLetter2;
    int x = 170;
    int y = 200;
    int margin = 7;
    int kl = 70;
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
