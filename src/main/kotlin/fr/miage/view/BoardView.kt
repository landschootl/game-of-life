package fr.miage.view

import fr.miage.game.Board
import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

/**
 * Display the board of the game
 */
class BoardView(private val board: Board, private val cellSize: Int) : JPanel() {


    /**
     * Draw the board
     */
    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        (0..board.dimension).forEach { x ->
            (0..board.dimension).forEach { y ->
                g.color = if (board.isAlive(x, y)) Color.GREEN else Color.GRAY
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize)
                g.color = Color.BLACK
                g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize)
            }
        }

    }

}