package test.java;
import main.XandO;
import org.junit.*;

public class XandOtest
{
    XandO xandO;
    @Before
    public void SetUp()
    {
        xandO= new XandO();
    }

    @Test
    public void checkWin()
    {

        // Horizontal win for 'X'
        xandO.setCell(0, 0, 'X');
        xandO.setCell(0, 1, 'X');
        xandO.setCell(0, 2, 'X');
        Assert.assertTrue(xandO.checkWin('X'));

        xandO.reset();
        xandO.setCell(0, 0, 'O');
        xandO.setCell(1, 0, 'O');
        xandO.setCell(2, 0, 'O');
        Assert.assertTrue(xandO.checkWin('O'));

        // Diagonal win for 'X'
        xandO.reset();
        xandO.setCell(0, 0, 'X');
        xandO.setCell(1, 1, 'X');
        xandO.setCell(2, 2, 'X');
        Assert.assertTrue(xandO.checkWin('X'));

        // No win
        xandO.reset();
        xandO.setCell(0, 0, 'X');
        xandO.setCell(1, 1, 'O');
        xandO.setCell(2, 2, 'X');
        Assert.assertFalse(xandO.checkWin('X'));
    }

    @Test
    public void CheckDraw()
    {
        xandO.reset();
        xandO.setCell(0, 0, 'X');
        xandO.setCell(0, 1, 'O');
        xandO.setCell(0, 2, 'X');
        xandO.setCell(1, 0, 'X');
        xandO.setCell(1, 1, 'O');
        xandO.setCell(1, 2, 'O');
        xandO.setCell(2, 0, 'O');
        xandO.setCell(2, 1, 'X');
        xandO.setCell(2, 2, 'X');
        Assert.assertTrue(xandO.draw());
    }

    @Test
    public void CheckReset()
    {
        xandO.setCell(0, 0, 'X');
        xandO.setCell(0, 1, 'O');
        xandO.setCell(0, 2, 'X');
        xandO.reset();
        char cellValue = xandO.getCell(0, 0);
        char currentPlayer = xandO.getCurrentPlayer();
        Assert.assertFalse(cellValue == 'X' || cellValue == 'O');
        Assert.assertEquals('X', currentPlayer);
    }
}
