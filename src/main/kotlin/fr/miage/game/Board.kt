package fr.miage.game

import java.util.*


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
        val random = Random()
        (0 until nbAlive).forEach {
            livingCells.add(random.nextInt(dimension) to random.nextInt(dimension))
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
    fun isAlive(x: Int, y: Int): Boolean = livingCells.contains(x to y)


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
                    cell - (x to y)
                }
            } - cell


    /**
     * Extension to calculate the difference between a cell and another one
     */
    operator fun Cell.minus(other: Cell): Cell = first - other.first to second - other.second


    /**
     * Run an iteration of the game of life
     */
    fun evolve() {
        var newLivingCells: MutableList<Cell> = mutableListOf()
        (0..livingCells.size).forEach { x ->
            (0..livingCells.size).forEach { y ->
                var nbAliveNeighbors = getNeighbors(x to y).filter {isAlive(it.first,it.second)}.size
                var currentCellIsAlive = isAlive(x, y)
                if(getNextState(nbAliveNeighbors, currentCellIsAlive)){
                    newLivingCells.add(x to y)
                }
            }
        }
        livingCells = newLivingCells
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
    fun getNextState(nbAliveNeighbors: Int, currentCellIsAlive: Boolean): Boolean =
        when (nbAliveNeighbors) {
            3 -> true
            2 -> currentCellIsAlive
            else -> false
        }


}

/**
 * We create a alias only for readability instead of using the Pair<Int,Int> object
 * With that you can use Cell as a Pair<Int,Int>
 */
typealias Cell = Pair<Int, Int>
