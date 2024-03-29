/*
 * CommandTopComponent.java
 *
 * Copyright (c) 2009 Ruben Laguna <ruben.laguna at gmail.com>. All rights reserved.
 *
 * This file is part of XBeeApplication.
 *
 * XBeeApplication is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XBeeApplication is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with XBeeApplication.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rubenlaguna.xbeemodule;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress16;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeRequest;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.zigbee.NodeDiscover;
import com.rapplogic.xbee.api.zigbee.ZNetExplicitRxResponse;
import com.rapplogic.xbee.api.zigbee.ZNetExplicitTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.util.DoubleByte;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.jdesktop.swingworker.SwingWorker;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class CommandTopComponent extends TopComponent implements LookupListener {

    private static CommandTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "CommandTopComponent";
    private static Lookup.Result<NodeDiscover> result;

    private CommandTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(CommandTopComponent.class, "CTL_CommandTopComponent"));
        setToolTipText(NbBundle.getMessage(CommandTopComponent.class, "HINT_CommandTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));
        result = NodesTopComponent.findInstance().getLookup().lookupResult(NodeDiscover.class);
        result.addLookupListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        readTemperatureJButton = new javax.swing.JButton();
        readIlluminanceJButton = new javax.swing.JButton();
        readHeadingJButton = new javax.swing.JButton();
        readTiltJButton = new javax.swing.JButton();
        tempJLabel = new javax.swing.JLabel();
        illuminanceJLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        selectedAddressJLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(readTemperatureJButton, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.readTemperatureJButton.text")); // NOI18N
        readTemperatureJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readTemperatureJButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(readIlluminanceJButton, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.readIlluminanceJButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(readHeadingJButton, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.readHeadingJButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(readTiltJButton, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.readTiltJButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(tempJLabel, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.tempJLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(illuminanceJLabel, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.illuminanceJLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel7.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.jLabel9.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(selectedAddressJLabel, org.openide.util.NbBundle.getMessage(CommandTopComponent.class, "CommandTopComponent.selectedAddressJLabel.text")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(readTemperatureJButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(tempJLabel))
                    .add(layout.createSequentialGroup()
                        .add(readIlluminanceJButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(illuminanceJLabel))
                    .add(layout.createSequentialGroup()
                        .add(readHeadingJButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3))
                    .add(layout.createSequentialGroup()
                        .add(readTiltJButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9))
                    .add(selectedAddressJLabel))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {readHeadingJButton, readIlluminanceJButton, readTemperatureJButton, readTiltJButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(readTemperatureJButton)
                    .add(tempJLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(readIlluminanceJButton)
                    .add(illuminanceJLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(readHeadingJButton)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(readTiltJButton)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel8)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 119, Short.MAX_VALUE)
                .add(selectedAddressJLabel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void readTemperatureJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readTemperatureJButtonActionPerformed

        final XBee xbee = XBeeTopComponent.findInstance().getLookup().lookup(XBee.class);
        if (null == xbee) {
            return;
        }
        final NodeDiscover xd = NodesTopComponent.findInstance().getLookup().lookup(NodeDiscover.class);
        if (null == xd) {
            return;
        }

        SwingWorker sw = new SwingWorker<ZNetExplicitRxResponse, Void>() {

            @Override
            protected ZNetExplicitRxResponse doInBackground() throws Exception {


                XBeeAddress64 addr64 = xd.getNodeAddress64();
                XBeeAddress16 addr16 = xd.getNodeAddress16();
                DoubleByte clusterId = new DoubleByte(0x04, 0x02);
                int[] payload = new int[]{0x00,0x01,0x00, 0x00, 0x00}; //zcl header, transaction id, read command 0x00, attribute 0x00 0x00 temperature

                // first request we just send 64-bit address.  we get 16-bit network address with status response
                ZNetExplicitTxRequest request = new ZNetExplicitTxRequest(xbee.getNextFrameId(), addr64, addr16,
                        ZNetTxRequest.DEFAULT_BROADCAST_RADIUS, ZNetTxRequest.UNICAST_OPTION, payload, 0x01, 0x01, clusterId, new DoubleByte(0x01, 0x04));

                xbee.sendAsynchronous(request);
                while (true) {
                    XBeeResponse response = xbee.getResponse(5000);
                    if (response.getApiId() == ApiId.ZNET_EXPLICIT_RX_RESPONSE) {
                        return (ZNetExplicitRxResponse)response;
                    }

                }
            }

            @Override
            protected void done() {
                try {
                    ZNetExplicitRxResponse resp = get();
                    int[] bytes = resp.getData();
                    int temp = bytes[bytes.length-2];
                    temp = temp << 8;
                    temp = temp + bytes[bytes.length-1];
                    String toTxt = Double.toString(temp/100.0);
                    tempJLabel.setText(toTxt);
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        sw.execute();


    // replace with end device's 64-bit address (SH + SL)
    //XBeeAddress64 addr64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x0a, 0x3e, 0x02);

    //XBeeRequest frameData = new XBeeRequest();
    //xbee.sendAsynchronous(frameData);

}//GEN-LAST:event_readTemperatureJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel illuminanceJLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton readHeadingJButton;
    private javax.swing.JButton readIlluminanceJButton;
    private javax.swing.JButton readTemperatureJButton;
    private javax.swing.JButton readTiltJButton;
    private javax.swing.JLabel selectedAddressJLabel;
    private javax.swing.JLabel tempJLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized CommandTopComponent getDefault() {
        if (instance == null) {
            instance = new CommandTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the CommandTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized CommandTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(CommandTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof CommandTopComponent) {
            return (CommandTopComponent) win;
        }
        Logger.getLogger(CommandTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    public void resultChanged(LookupEvent ev) {
        Iterator<? extends NodeDiscover> it = result.allInstances().iterator();
        if (it.hasNext()) {
            NodeDiscover o = it.next();
            selectedAddressJLabel.setText(o.getNodeAddress64().toString());
        }

    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return CommandTopComponent.getDefault();
        }
    }
}
