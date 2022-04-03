import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class DiversTest {

    @ParameterizedTest (name = "{0} est une réussite")
    @ValueSource(ints = {60, 75, 100})
    void estReussite(int arg ){
        assertTrue(Divers.estReussite(arg));
    }
    void exposantDeux(int arg1, int arg2){


    }
}
