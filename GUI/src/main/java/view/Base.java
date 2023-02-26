package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Base {
    static class ShowPassword extends JButton {
        ImageIcon show = new ImageIcon("Public\\Show.png");

        LineBorder lineBorder =new LineBorder(Color.decode("#16B13B"), 2, true);

        ShowPassword(int x, int y, int width, int height){
            setIcon(show);
            setBorder(lineBorder);
            setAlignmentX(CENTER_ALIGNMENT);
            setAlignmentY(CENTER_ALIGNMENT);
            setForeground(Color.decode("#16B13B"));
            setBounds(x,y,width,height);
            setBackground(Color.white);
            setEnabled(false);
            setDisabledIcon(show);
        }
    }

    public static class Button extends JButton{
        LineBorder lineBorder =new LineBorder(Color.decode("#16B13B"), 2, true);

        public Button(String text, int fontSize, int x, int y, int width, int height){
            setText(text);
            setFont(new Font("Arial",Font.BOLD,fontSize));
            setAlignmentX(CENTER_ALIGNMENT);
            setAlignmentY(CENTER_ALIGNMENT);
            setBounds(x,y,width,height);
            setBackground(Color.decode("#16B13B"));
            setForeground(Color.white);
            setBorder(lineBorder);
        }
    }

    static class Label extends JLabel{
        Label(String text, String fontName, int fontSize, int x, int y, int width, int height){
            setText(text);
            setForeground(Color.decode("#16B13B"));
            setFont(new Font(fontName,Font.BOLD,fontSize));
            setBounds(x,y,width,height);
        }
        Label(String text, int fontSize){
            setText(text);
            setHorizontalAlignment(SwingConstants.CENTER);
            setForeground(Color.decode("#ffffff"));
            setFont(new Font("Cooper Black",Font.BOLD,fontSize));
            setBackground(Color.decode("#16B13B"));
            setBounds(85, 0, 298, 73);
        }
    }

    public static class TextField extends JTextField {
        LineBorder lineBorder = new LineBorder(Color.decode("#16B13B"), 2, true);

        public TextField(String placeholder, int fontSize, int x, int y, int width, int height) {
            setText(placeholder);
            setFont(new Font("Arial", Font.PLAIN, fontSize));
            setBounds(x, y, width, height);
            setForeground(Color.decode("#7CCB6C"));
            setBorder(lineBorder);
            setBorder(BorderFactory.createCompoundBorder(
                    getBorder(),
                    BorderFactory.createEmptyBorder(5, 8, 5, 5)));
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        setText("");
                        setForeground(Color.decode("#16B13B"));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setForeground(Color.decode("#7CCB6C"));
                        setText(placeholder);
                    }
                }
            });
        }

        TextField(String placeholder, String text, int x, int y, int width, int height) {
            setText(text);
            setFont(new Font("Arial", Font.PLAIN, 16));
            setBounds(x, y, width, height);
            setForeground(Color.decode("#16B13B"));
            setBorder(lineBorder);
            setBorder(BorderFactory.createCompoundBorder(
                    getBorder(),
                    BorderFactory.createEmptyBorder(5, 8, 5, 5)));
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        setText("");
                        setForeground(Color.decode("#16B13B"));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setForeground(Color.decode("#7CCB6C"));
                        setText(placeholder);
                    }
                }
            });
        }

        TextField(String placeholder, int fontSize, int x, int y, int width, int height, JButton nextButton) {
            setText(placeholder);
            setFont(new Font("Arial", Font.PLAIN, fontSize));
            setBounds(x, y, width, height);
            setForeground(Color.decode("#16B13B"));
            setBorder(lineBorder);
            setBorder(BorderFactory.createCompoundBorder(
                    getBorder(),
                    BorderFactory.createEmptyBorder(5, 8, 5, 5)));
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeholder)) {
                        nextButton.setEnabled(true);
                        setText("");
                        setForeground(Color.decode("#16B13B"));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        nextButton.setEnabled(false);
                        setForeground(Color.decode("#7CCB6C"));
                        setText(placeholder);
                    }
                }
            });
        }
    }

    static class PasswordField extends JPasswordField {
        LineBorder lineBorder =new LineBorder(Color.decode("#16B13B"), 2, true);

        PasswordField(String placeholder,int fontSize, int x, int y, int width, int height, JButton showPasswordButton){
            setText(placeholder);
            setEchoChar((char)0);
            setFont(new Font("Arial",Font.PLAIN,fontSize));
            setBounds(x,y,width,height);
            setForeground(Color.decode("#7CCB6C"));
            setBorder(lineBorder);
            setBorder(BorderFactory.createCompoundBorder(
                    getBorder(),
                    BorderFactory.createEmptyBorder(5, 8, 5, 5)));
            addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    String ps = String.copyValueOf(getPassword());
                    if (ps.equals(placeholder)) {
                        showPasswordButton.setEnabled(true);
                        setEchoChar('\u25cf');
                        setText("");
                        setForeground(Color.decode("#16B13B"));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    String ps = String.copyValueOf(getPassword());
                    if (ps.isEmpty()) {
                        showPasswordButton.setEnabled(false);
                        setEchoChar((char)0);
                        setForeground(Color.decode("#7CCB6C"));
                        setText(placeholder);
                    }
                }}
            );
        }
    }

    public static class topButton extends JButton{

        public topButton(String text, String side){
            setText(text);
            setBorder(new LineBorder(Color.decode("#16B13B"), 2));
            setFont(new Font("",Font.PLAIN,45));
            setBackground(Color.white);
            setForeground(Color.decode("#16B13B"));
            if (side.equals("left")){
                setBounds(15, 15, 55, 45);
            } else if (side.equals("right")){
                setBounds(405, 15, 55, 45);
            }
        }
        topButton(Icon icon, String side){
            setIcon(icon);
            if (side.equals("left")){
                setBounds(15,15,55,45);
            } else if (side.equals("right")){
                setBounds(405, 15, 55, 45);
            }
            setBorderPainted(false);
        }
    }

}


