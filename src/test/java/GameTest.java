import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void WinFirstPlayer() {
        Player player1 = new Player(1, "Олег", 4);
        Player player2 = new Player(2, "Гоген", 3);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Олег", "Гоген");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player player1 = new Player(1, "Олег", 3);
        Player player2 = new Player(2, "Гоген", 3);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Олег", "Гоген");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayer() {
        Player player1 = new Player(1, "Олег", 3);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Гоген");
        });
    }

    @Test
    void notRegisteredPlayer1Exception() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("PlayerNotExists", "Player2"));
    }

    @Test
    void shouldReturn2WhenPlayer2Stronger() {
        Game game = new Game();
        game.register(new Player(1,"Pl1", 3));
        game.register(new Player(2,"Pl2", 4));

        Assertions.assertEquals(2, game.round("Pl1", "Pl2"));
    }

    @Test
    void shouldReturnId() {
        Player player = new Player(1,"PlayerName", 1);
        Assertions.assertEquals(1, player.getId());
    }
}