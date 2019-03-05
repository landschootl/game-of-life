package fr.miage

import fr.miage.game.Board
import fr.miage.game.Cell
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Board test case.
 */
class BoardTest {

    /******************************************************************************************************
     ******************************** Test the evolution of the board *************************************
     ******************************************************************************************************/

    @Test
    fun testOneIterationOfTheGameWithStableStructure() {
        //Create a game with dimension 4*4 and 10 living cells
        val board = Board(4, 10)

        //Set the initial living cells
        val initialLivingCells = mutableListOf(0 to 0, 1 to 0, 0 to 1, 1 to 1)
        board.livingCells = initialLivingCells

        // Here we are testing a stable schema of the game of life
        // So we should have the same living cells as the initialisation (and forever)

        //test one iteration
        assertTrue {
            runOneIterationAndCompareLivingCells(board, initialLivingCells)
        }
    }

    @Test
    fun testSeveralIterationOfTheGameWithStableStructure() {
        //Create a game with dimension 4*4 and 10 living cells
        val board = Board(4, 10)

        //Set the initial living cells
        val initialLivingCells = mutableListOf(0 to 0, 1 to 0, 0 to 1, 1 to 1)
        board.livingCells = initialLivingCells

        // Here we are testing a stable schema of the game of life
        // So we should have the same living cells as the initialisation (and forever)

        // Test a lot of iterations
        // Indication : use the method runOneIterationAndCompareLivingCells(board, expectedLivingCells)
        TODO()
    }


    @Test
    fun testTwoIterationOfTheGameWithBlinker() {

        // Here we want to test the evolution of an oscillator
        // called a "blinker" (http://conwaylife.com/w/index.php?title=Blinker)
        // The blinker oscillates with a periodicity of 2.
        // It means that every 2 iterations it comebacks at its initial state

        // We create a game with dimension 4*4 and 10 living cells (we don't care about the living cells)
        val board = Board(3, 10)

        // We define the initial state of the blinker (vertical) like that :
        // | |■| |
        // | |■| |
        // | |■| |
        val verticalBlinker = mutableListOf(1 to 0, 1 to 1, 1 to 2)
        board.livingCells = verticalBlinker


        // We define the expected living cells after 1 evolution. We want this :
        // | | | |
        // |■|■|■|
        // | | | |
        val horizontalBlinker = TODO()


        // Test that the livingCells alternates between the verticalBlinker list and the horizontalBlinker list
        // Indication : use the method runOneIterationAndCompareLivingCells(board, expectedLivingCells)
        TODO()

    }

    /**
     * Return the difference between the living cells and the expected living cells after 1 iteration
     * of the Game Of Life.
     *
     * @param board instance of a board
     * @param expectedLivingCells the list of the expected living cells after 1 iteration
     *
     * @return if the list of living cells is the same as the expected one
     */
    private fun runOneIterationAndCompareLivingCells(board: Board,
                                                     expectedLivingCells: MutableList<Cell>): Boolean {

        //Run one iteration of the game of life
        board.evolve()

        //Get the new living cells
        val newLivingCells = board.livingCells

        //Test if our 2 lists are equals and return the result
        return (newLivingCells.size == expectedLivingCells.size &&
                newLivingCells.containsAll(expectedLivingCells) &&
                newLivingCells.containsAll(expectedLivingCells))
    }


    /******************************************************************************************************
     ********************************** Test get next state of a Cell *************************************
     ******************************************************************************************************/

    @Test
    fun testGetNextStateAliveAnd0Neighbor() {
        val board = Board(5, 10)

        //Test with no living neighbors of a living cell
        val nbNeighbors = 0
        val currentCellIsAlive = true

        assertFalse { board.getNextState(nbNeighbors, currentCellIsAlive) }
    }

    @Test
    fun testGetNextStateDeadAnd0Neighbor() {
        //Test with no living neighbors of a living cell
        TODO()
    }

    @Test
    fun testGetNextStateAliveAnd1Neighbour() {
        //Test with 1 living neighbors of a living cell
        TODO()
    }

    @Test
    fun testGetNextStateDeadAnd1Neighbour() {
        //Test with 1 living neighbors of a living cell
        TODO()
    }

    @Test
    fun testGetNextStateAliveAnd2Neighbors() {
        //Test with 2 living neighbors of a living cell
        TODO()
    }

    @Test
    fun testGetNextStateDeadAnd2Neighbors() {
        //Test with 2 living neighbors of a dead cell
        TODO()
    }

    @Test
    fun testGetNextStateDeadAnd4Neighbors() {
        //Test with a 4 living neighbors
        TODO()
    }

    @Test
    fun testGetNextStateAliveAnd3Neighbors() {
        //Test with 3 living neighbors of a living cell
        TODO()
    }

    @Test
    fun testGetNextStateDeadAnd3Neighbors() {
        //Test with 3 living neighbors of a dead cell
        TODO()
    }

    @Test
    fun testGetNextStateAliveAnd4Neighbors() {
        //Test with a 4 living neighbors
        TODO()
    }


    /******************************************************************************************************
     *********************************** Test getNeighbors of a Cell **************************************
     ******************************************************************************************************/

    @Test
    fun testGetNeighbors() {

        // Develop a test to test the getNeighbors function
        // Here we want to test the neighbors of the Cell (1,1) of a 4*4 board
        // Indication : you can define a list of neighbors manually with : mutableListOf(Pair<Int,Int>...)

        //Create a board with a size 4*4 with 1 living cell
        val board = Board(4, 1)
        val cellToTest = 1 to 1

        TODO()

    }


    /******************************************************************************************************
     ************************************** Test init of the board ****************************************
     ******************************************************************************************************/

    @Test
    fun testOneCellAlive() {
        //Create a board with a size 5*5 with 1 living cell
        val board = Board(5, 1)

        assertEquals(board.livingCells.size, 1)
    }


    @Test
    fun testNoCellAlive() {
        //Create a board with a size 5*5 without living cell
        val board = Board(5, 0)

        assertEquals(board.livingCells.size, 0)
    }

    @Test
    fun testAllCellsAreAlive() {
        //Create a board with a size 1*1 and all cells are alive (1)
        val board = Board(1, 1)
        val fullLivingCells = mutableListOf(0 to 0)

        //set all the cells to the alive state
        board.livingCells = fullLivingCells

        assertTrue { board.isAlive(0, 0) }
    }


    /******************************************************************************************************
     ************************************** Test the minus function ***************************************
     ******************************************************************************************************/



    @Test
    fun testDifferenceBetweenCells1() {
        //Create a board with a size 3*3 and all cells are alive (9)
        val board = Board(3, 9)
        val cell1 = 0 to 0
        val cell2 = 1 to 1
        val expectedDifference = -1 to -1

        val difference = with(board) {
            cell1 - cell2
        }
        assertEquals(difference, expectedDifference)
    }

    @Test
    fun testDifferenceBetweenCells2() {
        //Create a board with a size 3*3 and all cells are alive (9)
        val board = Board(3, 9)
        val cell1 = 1 to 0
        val cell2 = 0 to -1
        val expectedDifference = 1 to 1

        val difference = with(board) {
            cell1 - cell2
        }
        assertEquals(difference, expectedDifference)
    }

    @Test
    fun testDifferenceBetweenCells3() {
        //Create a board with a size 3*3 and all cells are alive (9)
        val board = Board(3, 9)
        val cell1 = -1 to 1
        val cell2 = 1 to -1
        val expectedDifference = -2 to 2

        val difference = with(board) {
            cell1 - cell2
        }
        assertEquals(difference, expectedDifference)
    }

}