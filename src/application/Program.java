package application;


import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Program.class.getName());

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();


        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                logger.info("");
                logger.info("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                logger.info("");
                logger.info("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                logger.info(e.getMessage());
                sc.nextLine();
            }

        }
    }
}
