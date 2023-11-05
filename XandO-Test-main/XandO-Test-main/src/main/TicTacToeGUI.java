package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {

    String uniChar = "User ";
    private JFrame frame;
    private JButton[] buttons;

    private boolean xTurn = true;

    public TicTacToeGUI() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 48));
            frame.add(buttons[i]);

            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (buttons[finalI].getText().equals("") && !isGameWon()) {
                        if (xTurn) {
                            buttons[finalI].setText("X");
                        } else {
                            buttons[finalI].setText("O");
                        }
                        xTurn = !xTurn;
                    }

                    if (isGameWon()) {
                        JOptionPane.showMessageDialog(frame,  uniChar + (xTurn ? "O" : "X") + " wins!");
                        resetBoard();
                    } else if (isBoardFull()) {
                        JOptionPane.showMessageDialog(frame, "It's a draw!");
                        resetBoard();
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    private boolean isGameWon() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (!buttons[i].getText().equals("") &&
                    buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i].getText().equals(buttons[i + 6].getText())) {
                return true;
            }
            if (!buttons[i * 3].getText().equals("") &&
                    buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText()) &&
                    buttons[i * 3].getText().equals(buttons[i * 3 + 2].getText())) {
                return true;
            }
        }
        if (!buttons[0].getText().equals("") &&
                buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[0].getText().equals(buttons[8].getText())) {
            return true;
        }
        if (!buttons[2].getText().equals("") &&
                buttons[2].getText().equals(buttons[4].getText()) &&
                buttons[2].getText().equals(buttons[6].getText())) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
