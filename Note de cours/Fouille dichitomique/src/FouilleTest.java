import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FouilleTest {

    int[][] tabTest = {{14,22,33},{10,2,-4}};

    @ParameterizedTest(name = "La somme de la ligne {0} donne {1}")
    @CsvSource({
            "0, 5",
            "1,60"
    })
    void sommeUneLigne(int ligne, int expectedResult){
        int actualResult = Fouille.sommeUneLigne(tabTest, ligne);
            assertEquals(actualResult,expectedResult);
        }
    }
