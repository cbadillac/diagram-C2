package com.baddyTeam.DCGUI;

import java.awt.*;

/**
 * Created by Cristobal on 27-07-2014.
 */
public class FirstNode extends NodeDC {
    private static int id = 0;
    private FirstNodeView view;

    public FirstNode() {
        super(id++);
        this.view = new FirstNodeView(this);
        super.connected = true;
    }


    @Override
    public String toC() {
        return "int main()";
    }
    @Override
    public String getType() {
        return NodeDC.typeOne;
    }

    @Override
    public void updateView(Graphics g) {
        view.updateView(g);
    }
    @Override
    public NodeDCView getView() {
        return view;
    }

    @Override
    public String getText() {
        return null;
    }

}
