import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.readString;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivan_igorevich");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final Path paths = Paths.get("chat.txt");

    ClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Files.write(paths, (tfMessage.getText() + "\n").getBytes(), StandardOpenOption.APPEND);
                    log.setText(readString(paths));
                } catch (IOException i) {
                    i.printStackTrace();
                }
                tfMessage.setText("");
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    log.setText(readString(paths));
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });
        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Files.write(paths, (tfMessage.getText() + "\n").getBytes(), StandardOpenOption.APPEND);
                    log.setText(readString(paths));
                } catch (IOException i) {
                    i.printStackTrace();
                }
                tfMessage.setText("");
            }
        });
        setVisible(true);
    }
}