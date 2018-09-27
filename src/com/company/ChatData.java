package com.company;

import javax.swing.*;

public class ChatData {
    JTextArea msgOut = new JTextArea();

    public void addObj(JTextArea comp) { //수정할 컴포넌트 인자로 받음
        msgOut = comp;
    }
    public void refreshData(String msg) { //받아온 메세지 계속 추가
        msgOut.append(msg);
    }
}