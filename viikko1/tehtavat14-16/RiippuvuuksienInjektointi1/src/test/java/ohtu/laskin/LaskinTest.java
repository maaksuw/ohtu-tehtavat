package ohtu.laskin;



import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LaskinTest {

    @Test
    public void yksiSummaOikein() {
        
    }
}

class IOStub implements IO {

    int[] inputs;
    int mones;
    ArrayList<String> outputs;

    public IOStub(int... inputs) {
        this.inputs = inputs;
        this.outputs = new ArrayList<String>();
    }

    public int nextInt() {
        return inputs[mones++];
    }

    public void print(String m) {
        outputs.add(m);
    }
}
