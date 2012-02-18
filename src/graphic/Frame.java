package graphic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import realization.ChangerKeys;
import realization.ParserStringToKey;
import realization.Transposition;
import Interface.Crypto;

public class Frame extends JFrame
{

    private JPanel     contentPane;
    private JTextField encodeTextField;
    private JTextField decodeTextField;
    private Crypto     crypto = null;

    private int[]      key    = new int[] { 2, 5, 3, 4, 1, 6 };
    private JTextField enterKeyText;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Frame frame = new Frame();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Frame()
    {
        setResizable(false);
        setTitle("Laba1Defence");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 279);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 5, 434, 236);
        contentPane.add(panel);
        panel.setLayout(null);

        encodeTextField = new JTextField();
        encodeTextField.setBounds(10, 72, 188, 20);
        panel.add(encodeTextField);
        encodeTextField.setColumns(10);

        decodeTextField = new JTextField();
        decodeTextField.setEditable(false);
        decodeTextField.setBounds(236, 72, 188, 20);
        panel.add(decodeTextField);
        decodeTextField.setColumns(10);

        JLabel labelEncode = new JLabel("Please, enter a text, which we encode: ");
        labelEncode.setHorizontalAlignment(SwingConstants.LEFT);
        labelEncode.setLabelFor(encodeTextField);
        labelEncode.setBounds(10, 11, 205, 16);
        panel.add(labelEncode);

        JLabel labelDecode = new JLabel("Decode this text:");
        labelDecode.setBounds(236, 11, 188, 16);
        panel.add(labelDecode);

        final JLabel labelInfo = new JLabel("");
        labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
        labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelInfo.setBounds(42, 38, 350, 23);

        panel.add(labelInfo);

        enterKeyText = new JTextField();
        enterKeyText.setBounds(10, 169, 205, 20);
        panel.add(enterKeyText);
        enterKeyText.setColumns(10);

        JLabel lblNewLabel = new JLabel("If you want enter your own key with spaces:");
        lblNewLabel.setBounds(10, 144, 223, 14);
        panel.add(lblNewLabel);

        JButton changeKeyButton = new JButton("changeKey");
        changeKeyButton.setBounds(10, 200, 89, 23);
        changeKeyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (!enterKeyText.getText().isEmpty())
                {
                    //функционал, мен€ющий ключ..........
                    String[] keys = enterKeyText.getText().split("\\s+");
                    ChangerKeys change = new ChangerKeys(key);
                    int [] newKey = change.changeKey(keys);
                    if (newKey == null)
                    {
                        JOptionPane.showMessageDialog(null, "Bad data you write!", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(newKey[0]==-1)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot be repeats in key", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        key = newKey; 
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You are not enter a new key man, enter please!!!", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(changeKeyButton);

        JButton buttonEncode = new JButton("encode");
        buttonEncode.setBounds(109, 113, 89, 23);
        buttonEncode.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {

                if (!encodeTextField.getText().isEmpty())
                {
                    crypto = new Transposition(encodeTextField.getText(), key);

                    String code = crypto.code();
                    if (code != null)
                    {
                        ParserStringToKey please = new ParserStringToKey(encodeTextField.getText(), key.length);

                        labelInfo.setText(please.parse());
                        decodeTextField.setText(code);
                        encodeTextField.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The message is not dividible to key, this method is bad to apply", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "There is nothing to encode, please enter something", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buttonEncode);

        JButton buttonDecode = new JButton("decode");
        buttonDecode.setBounds(236, 113, 89, 23);
        buttonDecode.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                if (!decodeTextField.getText().equals(""))
                {
                    String decode = new String(crypto.decode(decodeTextField.getText()));
                    if (decode != null)
                    {
                        encodeTextField.setText(decode);
                        decodeTextField.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The message is bad", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "There is nothing to decode", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buttonDecode);

        JButton btnNewButton = new JButton("exit");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        btnNewButton.setBounds(303, 200, 89, 23);
        panel.add(btnNewButton);

    }

}
