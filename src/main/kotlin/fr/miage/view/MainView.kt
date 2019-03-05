package fr.miage.view

import fr.miage.game.Board
import java.util.*
import javax.swing.JFrame

/**
 * View of the Game of life
 * Initialization of the game window
 */
class MainView {

    private val frame = JFrame()
    private val board: Board
    private val boardView: BoardView

    /**
     * The init block is executed just after the constructor(s)
     * Here we just init the JFrame and launch the game
     */
    init {
        frame.title = "Game of life"
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(700, 730)


        /**
         * Init the board with a dimension 50 * 50
         * and 300 living cells
         */
        val boardSize = 50
        val initialLivingCells = 300
        this.board = Board(boardSize, initialLivingCells)
        this.boardView = BoardView(board, 695 / boardSize)

        frame.contentPane.add(boardView)
        frame.isVisible = true
    }


    /**
     * Start the game !
     */
    fun start() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                board.evolve()
                boardView.repaint()
            }
        },50, 50)
    }
}

/**
 * Entry point of the program
 * Call the start method of the game
 */
fun main(args: Array<String>) {
    MainView().start()
}


