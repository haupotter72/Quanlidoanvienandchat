package ConnData;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
public class ChatPanels extends JPanel {

    Socket socket = null;
    BufferedReader bf = null;
    DataOutputStream os = null;
    OutputThread  t = null;
    String sender;
    String receiver;
    JTextArea txtMessages;
    /**
     * Create the panel.
     */
    public ChatPanels(Socket s, String sender,String reciever) {



        setForeground(Color.BLACK);
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(1, 2, 0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        JTextArea txtMessage = new JTextArea();
        scrollPane.setViewportView(txtMessage);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(txtMessage.getText().trim().length() == 0) return;
                try {
                    os.writeBytes(txtMessage.getText());
                    os.write(13); os.write(10);


                    os.flush();
                    txtMessage.append("\n" + sender + ": " + txtMessage.getText());
                    txtMessage.setText(" ");
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnSend);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

               txtMessage.setText("");
               txtMessages.setText("");

            }
        });
        panel.add(btnReset);

        JScrollPane scrollPane_1 = new JScrollPane();
        add(scrollPane_1, BorderLayout.CENTER);

        txtMessages = new JTextArea();
        scrollPane_1.setViewportView(txtMessages);

        socket = s;
        this.sender = sender;
        this.receiver = reciever;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new DataOutputStream(socket.getOutputStream());
            t = new OutputThread(s, txtMessages, sender, reciever);
            t.start();
        }
        catch(Exception e) {
        }
    }
    public JTextArea getTxtMessages() {
        return this.txtMessages;
    }
}

