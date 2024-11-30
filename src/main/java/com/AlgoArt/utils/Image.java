package com.AlgoArt.utils;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image extends JFrame{
    public Image(String path, String name) { //opens img in a new window
        //Setup basic JFrame
        JFrame frame = new JFrame ();
        frame.setTitle(name);
        frame.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/AlgoArt.ico")).getImage());
        frame.setSize(500,500);
        frame.setResizable(false);
        JLabel image = new JLabel(new ImageIcon(getClass().getResource("/img/"+path+"/"+name+".png")));
        image.setIcon(new ImageIcon(getClass().getResource("/img/"+path+"/"+name+".png")));
        frame.add(image);
        frame.setVisible(true);
    }
}

