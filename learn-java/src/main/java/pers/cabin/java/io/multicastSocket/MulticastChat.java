package pers.cabin.java.io.multicastSocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 聊天系统仅有一个类组成，没有相关得服务器，所有得客户都可以对等地通信。该类打开一个简单得带有通常输出和输入区域得聊天框架
 * 并且启动一个线程，去监听要输入得数据包
 * Created by caip on 2016/12/9.
 */
public class MulticastChat implements Runnable, WindowListener, ActionListener {

    protected InetAddress group;
    protected int port;

    protected Frame frame;
    protected TextArea output;
    protected TextField input;

    protected Thread listener;
    protected MulticastSocket socket;
    protected DatagramPacket outgoing, incoming;

    /**
     * 对group 和 port 进行初始化，并且初始化Frame
     *
     * @param group
     * @param port
     */
    public MulticastChat(InetAddress group, int port) {
        this.group = group;
        this.port = port;
        initAWT();
    }

    /**
     * 初始化 Frame
     */
    private void initAWT() {

        frame = new Frame("MulticastChat [" + group.getHostName() + ":" + port + "]");
        frame.addWindowListener(this);

        output = new TextArea();
        output.setEditable(false);
        input = new TextField();
        input.addActionListener(this);

        frame.setLayout(new BorderLayout());
        frame.add(output, "Center");
        frame.add(input, "South");
        frame.pack();

    }

    /**
     * 启动该聊天 系统
     */
    public synchronized void start() throws IOException {
        if (listener == null) {
            initNet();
            listener = new Thread(this);
            listener.start();
            frame.setVisible(true);
        }
    }

    protected void initNet() throws IOException {

        socket = new MulticastSocket(port);
        socket.setTimeToLive(1);
        socket.joinGroup(group);

        outgoing = new DatagramPacket(new byte[1], 1, group, port);
        incoming = new DatagramPacket(new byte[65508], 65508);

    }

    public synchronized void stop() throws IOException {

        frame.setVisible(false);
        if (listener != null) {
            listener.interrupt();
            listener = null;
            try {
                socket.leaveGroup(group);
            } finally {
                socket.close();
            }
        }
    }

    /**
     * 当Frame 框架启动时，输入得焦点输入到TextField
     *
     * @param e
     */
    @Override
    public void windowOpened(WindowEvent e) {

        input.requestFocus();
    }

    @Override
    public void windowClosing(WindowEvent e) {

        try {
            stop();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 没有使用到
     *
     * @param e
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * 没有使用到
     *
     * @param e
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * 没有使用到
     *
     * @param e
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * 没有使用到
     *
     * @param e
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * 没有使用到
     *
     * @param e
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            byte[] utf = e.getActionCommand().getBytes("UTF-8");
            outgoing.setData(utf);
            outgoing.setLength(utf.length);
            socket.send(outgoing);
            input.setText(" ");

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
            handleException(e1);
        }
    }

    private void handleException(IOException e1) {
        if (listener != null) {
            output.append(e1 + "\n");
            input.setVisible(false);
            frame.validate();
            if (listener != Thread.currentThread()) {
                listener.interrupt();
            }
            try {
                socket.leaveGroup(group);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        while (Thread.interrupted()) {
            try {
                incoming.setLength(incoming.getData().length);
                socket.receive(incoming);
                String message = new String(incoming.getData(), 0, incoming.getLength(), "UTF-8");
                output.append(message + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 主程序入口
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        if ((args.length != 1) || (args[0].indexOf(":") < 0)) {
            throw new IllegalArgumentException("Syntax: MulticastChat <group>:<port>");
        }
        int idx = args[0].indexOf(":");
        InetAddress group = InetAddress.getByName(args[0].substring(0, idx));
        int port = Integer.parseInt(args[0].substring(idx + 1));

        MulticastChat chat = new MulticastChat(group, port);
        chat.start();
    }

}
