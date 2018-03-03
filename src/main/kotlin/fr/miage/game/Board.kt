package fr.miage.game


/**
 * Board of the game
 * This class contains all the logic about the cells
 * It only knows the state of the board
 */
class Board(val dimension: Int, nbAlive: Int) {


    var livingCells: MutableList<Cell> = mutableListOf()

    /**
     * Init the board with the number of living cell in parameter
     * Generate random coordinate for these cells
     * and add it to the livingCells list
     */
    init {
        (0 until nbAlive).forEach {
            TODO()
        }
    }

    /**
     * Check if a cell(i,j) is alive
     *
     * @param x column index of a cell
     * @param y row index of a cell
     *
     * @return if the cell in parameter is alive (true) or dead (false)
     */
    fun isAlive(x: Int, y: Int): Boolean = TODO()


    /**
     * Return the neighbors of a cell as described :
     * (-1,-1)(-1,0)(-1,1)
     * (0,-1) Cell(0,0) (0,1)
     * (1,-1)(1,0)(1,1)
     *
     * @param cell the cell to count neighbors from
     *
     * @return the Cells list of neighbors
     */
    fun getNeighbors(cell: Cell): List<Cell> =
            (-1..1).flatMap { x ->
                (-1..1).map { y ->
                    TODO()
                }
            } - cell


    /**
     * Extension to calculate the difference between a cell and another one
     */
    operator fun Cell.minus(other: Cell): Cell = TODO()


    /**
     * Run an iteration of the game of life
     */
    fun evolve() {

        TODO()
    }


    /**
     * This function describes the logic of the game.
     * It determines if a cell will live or not
     *
     * @param nbAliveNeighbors number of alive neighbors
     * @param currentCellIsAlive current state of the cell (true if it is alive - else false)
     *
     * @return the new state of the cell - true if it alive - else false
     */
    fun getNextState(nbAliveNeighbors: Int, currentCellIsAlive: Boolean): Boolean = TODO()


}

/**
 * We create a alias only for readability instead of using the Pair<Int,Int> object
 * With that you can use Cell as a Pair<Int,Int>
 */
typealias Cell = Pair<Int, Int>
