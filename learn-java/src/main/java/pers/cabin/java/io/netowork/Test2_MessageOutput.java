package pers.cabin.java.io.netowork;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by caiping on 2016/12/23.
 */
public abstract class Test2_MessageOutput extends DataOutputStream {

    /**
     * Creates a new data output stream to write data to the specified
     * underlying output stream. The counter <code>written</code> is
     * set to zero.
     *
     * @param out the underlying output stream, to be saved for later
     *            use.
     * @see FilterOutputStream#out
     */
    public Test2_MessageOutput(OutputStream out) {
        super(out);
    }

    public abstract void send() throws IOException;

    public void send(String dst) throws IOException {
        String[] dsts = {dst};
        send(dsts);

    }

    public void send(String[] dsts) throws IOException {
        throw new IOException("send[] not supported");
    }

}
