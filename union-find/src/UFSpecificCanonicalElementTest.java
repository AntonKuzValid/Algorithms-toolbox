import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UFSpecificCanonicalElementTest {

    @Test
    public void find() {
        UFSpecificCanonicalElement uf = new UFSpecificCanonicalElement(10);
        Assertions.assertEquals(3, uf.find(3));
        Assertions.assertEquals(1, uf.find(1));
        uf.union(1, 3);
        Assertions.assertEquals(3, uf.find(3));
        Assertions.assertEquals(3, uf.find(1));
        uf.union(3, 5);
        Assertions.assertEquals(5, uf.find(1));
        Assertions.assertEquals(5, uf.find(5));
        Assertions.assertEquals(5, uf.find(3));
        uf.union(2, 1);
        Assertions.assertEquals(5, uf.find(1));
        Assertions.assertEquals(5, uf.find(2));
        Assertions.assertEquals(5, uf.find(5));
        Assertions.assertEquals(5, uf.find(3));
        Assertions.assertEquals(4, uf.find(4));
    }

}
