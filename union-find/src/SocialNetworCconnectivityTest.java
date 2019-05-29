import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringBufferInputStream;

public class SocialNetworCconnectivityTest {

    @Test
    public void run() {
        var str = "1 2\n3 4\n5 6\n7 8\n9 0\n0 1\n2 3\n4 5\n6 7\n8 9\n4 7\n";
        SocialNetworCconnectivity snc = new SocialNetworCconnectivity(10, 11, new StringBufferInputStream(str));
        Assertions.assertEquals(8, snc.run());
    }
}
