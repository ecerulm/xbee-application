/*
 * XBeeTopComponent.java
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

import com.rapplogic.xbee.api.AtCommand;
import com.rapplogic.xbee.api.AtCommandResponse;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress16;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.NodeDiscover;
import com.rapplogic.xbee.api.zigbee.ZNetNodeIdentificationResponse;
import com.rapplogic.xbee.util.IntArrayInputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.jdesktop.swingworker.SwingWorker;
import org.jletty.util.HexUtils;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class XBeeTopComponent extends TopComponent {

    private static XBeeTopComponent instance;
    private XBee xbee = new XBee();
    /** path to the icon used byel the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "XBeeTopComponent";
    private SerialPort serialPort;
    private static NodesTopComponent nodesInstance;
    private final InstanceContent instanceContent = new InstanceContent();

    private XBeeTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(XBeeTopComponent.class, "CTL_XBeeTopComponent"));
        setToolTipText(NbBundle.getMessage(XBeeTopComponent.class, "HINT_XBeeTopComponent"));
        associateLookup(new AbstractLookup(instanceContent));
        rescanJButtonActionPerformed(null);
//        setIcon(Utilities.loadImage(ICON_PATH, true));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        targetNodeIdentifierJLabel = new javax.swing.JLabel();
        targetNodeIdentifierJTextField = new javax.swing.JTextField();
        performNodeDiscoveryJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serialPortJComboBox = new javax.swing.JComboBox();
        rescanJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        speedJComboBox = new javax.swing.JComboBox();
        nodeDestinationJButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(targetNodeIdentifierJLabel, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.targetNodeIdentifierJLabel.text")); // NOI18N

        targetNodeIdentifierJTextField.setText(org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.targetNodeIdentifierJTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(performNodeDiscoveryJButton, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.performNodeDiscoveryJButton.text")); // NOI18N
        performNodeDiscoveryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performNodeDiscoveryJButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.jLabel1.text")); // NOI18N

        serialPortJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No port detected" }));
        serialPortJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                serialPortJComboBoxItemStateChanged(evt);
            }
        });
        serialPortJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialPortJComboBoxActionPerformed(evt);
            }
        });
        serialPortJComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                serialPortJComboBoxPropertyChange(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(rescanJButton, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.rescanJButton.text")); // NOI18N
        rescanJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rescanJButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.jLabel2.text")); // NOI18N

        speedJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a valid port first" }));
        speedJComboBox.setEnabled(false);
        speedJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedJComboBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(serialPortJComboBox, 0, 260, Short.MAX_VALUE)
                    .add(speedJComboBox, 0, 260, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rescanJButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(serialPortJComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(rescanJButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(speedJComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(nodeDestinationJButton, org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.nodeDestinationJButton.text")); // NOI18N
        nodeDestinationJButton.setActionCommand(org.openide.util.NbBundle.getMessage(XBeeTopComponent.class, "XBeeTopComponent.nodeDestinationJButton.actionCommand")); // NOI18N
        nodeDestinationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nodeDestinationJButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(targetNodeIdentifierJLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(targetNodeIdentifierJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(nodeDestinationJButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(performNodeDiscoveryJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(targetNodeIdentifierJLabel)
                    .add(targetNodeIdentifierJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(performNodeDiscoveryJButton)
                    .add(nodeDestinationJButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reconfigXbee() {
        try {
            Object selectedItem = serialPortJComboBox.getSelectedItem();
            if (null == selectedItem || "Select a port".equals(selectedItem)) {
                return;
            }
            String portToOpen = selectedItem.toString();
            selectedItem = speedJComboBox.getSelectedItem();
            if (null == selectedItem) {
                return;
            }
            int baudRate = Integer.parseInt(selectedItem.toString());
            xbee.close();
            xbee = new XBee();
            //xbee.open(portToOpen, Integer.getInteger(speedJComboBox.getSelectedItem().toString()));
            xbee.open(portToOpen, baudRate);
        } catch (XBeeException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void rescanJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rescanJButtonActionPerformed
        // TODO add your handling code here:
        SwingWorker sw = new SwingWorker<List, Void>() {

            @Override
            protected List doInBackground() throws Exception {
                Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();
                List toReturn = new ArrayList();
                while (portIdentifiers.hasMoreElements()) {
                    CommPortIdentifier portId = (CommPortIdentifier) portIdentifiers.nextElement();
                    if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                        toReturn.add(portId.getName());
                    }
                }
                return toReturn;
            }

            @Override
            protected void done() {
                try {
                    serialPortJComboBox.removeAllItems();

                    List items = get();

                    for (Object item : items) {
                        serialPortJComboBox.insertItemAt(item, 0);
                    }
                    serialPortJComboBox.insertItemAt("Select a port", 0);
                    serialPortJComboBox.setSelectedIndex(serialPortJComboBox.getItemCount() - 1);

                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        sw.execute();
}//GEN-LAST:event_rescanJButtonActionPerformed

    private void serialPortJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialPortJComboBoxActionPerformed
        reconfigXbee();
}//GEN-LAST:event_serialPortJComboBoxActionPerformed

    private void performNodeDiscoveryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performNodeDiscoveryJButtonActionPerformed

        SwingWorker sw = new SwingWorker<XBee, Void>() {

            @Override
            protected XBee doInBackground() throws Exception {

                AtCommand atCommand = new AtCommand("ND");
                xbee.sendAsynchronous(atCommand);
                Thread.sleep(5000);
                return xbee;

            }

            @Override
            protected void done() {

                //long packetCount = xbee.getPacketList().size();
                while ( xbee.getPacketList().size() > 0) {
                    try {
                        //XBeeResponse o = xbee.getPacketList().remove(0);
                        XBeeResponse o = null;

                        o = xbee.getResponse();

                        if ((o != null) && (o instanceof AtCommandResponse)) {
                            AtCommandResponse atCommandResponse = (AtCommandResponse) o;
                            if (!atCommandResponse.getCommand().equals("ND")) {
                                throw new RuntimeException("Wrong response. we were " +
                                        "expecting DN");
                            }
                            final NodeDiscover nd = NodeDiscover.parse((AtCommandResponse) atCommandResponse);
                            XBeeDevice xd = new XBeeDevice() {

                                public String getNodeIdentifier() {
                                    return nd.getNodeIdentifier();
                                }

                                public String getAddress16bit() {
                                    return nd.getNodeAddress16().toString();
                                }

                                public String getAddress64bit() {
                                    return nd.getNodeAddress64().toString();
                                }
                            };
                            instanceContent.add(xd);
                        }
                    } catch (XBeeException ex) {
                        Exceptions.printStackTrace(ex);
                    }

                    //int[] data = atCommandResponse.getValue();
                    //IntArrayInputStream in = new IntArrayInputStream(data);


                   
                }

            }
        };
        sw.execute();

//        SwingWorker sw = new SwingWorker<Map<String, String>, Void>() {
//
//            @Override
//            protected Map<String, String> doInBackground() throws Exception {
//                Map<String, String> toReturn = new HashMap<String, String>();
//                String portToOpen = serialPortJComboBox.getSelectedItem().toString();
//                System.out.println("portToOpen: " + portToOpen);
//                CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portToOpen);
//                if (serialPort != null) {
//                    serialPort.close();
//                }
//                serialPort = (SerialPort) portId.open("SimpleRead", 2000);
//                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
//                        SerialPort.STOPBITS_1,
//                        SerialPort.PARITY_NONE);
//                InputStream is = serialPort.getInputStream();
//
//                ReadListener readListener = new ReadListener(is);
//                readListener.start();
//                serialPort.notifyOnDataAvailable(true);
//                serialPort.addEventListener(readListener);
//
//                OutputStream os = serialPort.getOutputStream();
//                //7E 00 0B 08 52 44 4e 50 41 42 4c 49 54 4f 08
//                //00 01 02 03 04 05 06 07 08 09 10 11 12 13 14
//                //PABLITO = 50 41 42 4c 49 54 4f
//
//                String targetNodeIdentifier = targetNodeIdentifierJTextField.getText();
//                int len = targetNodeIdentifier.length();
//
//                int bufferLen = len +8;
//                byte[] buffer = new byte[bufferLen];
//                buffer[0] = 0x7e;
//                buffer[1] = 0x00;
//                System.err.println("targeNodeIdentifierlen: "+len);
//                buffer[2] = (byte) ((len + 4) & 0xFF);
//                System.err.println("buffer[2]: "+buffer[2]);
//                buffer[3] = 0x08; //at command
//                buffer[4] = 0x01; //frameid
//                buffer[5] = 0x44; //D
//                buffer[6] = 0x4e; //N
//                for (int i = 0; i < len; i++) {
//                    buffer[7 + i] = (byte) targetNodeIdentifier.charAt(i);
//                }
//                int checksum = 0;
//                for (int i = 3; i < buffer.length - 1; i++) {
//                    checksum += buffer[i];
//                }
//                checksum = checksum & 0xFF;
//                checksum = 0xFF - checksum;
//                System.out.println("checksum: "+checksum);
//                buffer[bufferLen - 1] = (byte) checksum;
//
//                System.out.println("len: "+len);
//
//                byte[] buffer2 =  new byte[] {(byte)0x7e,(byte)0x00,(byte)0x04,(byte)0x08,(byte)0x52,(byte)0x4d,(byte)0x59,(byte)0xff};
//                System.out.println(Utils.toHexDump(buffer2, 16));
//                os.write(buffer2);
//                //serialPort.close();
//
//                return toReturn;
//            //throw new UnsupportedOperationException("Not supported yet.");
//            }
//
//            @Override
//            protected void done() {
//                try {
//                    Map<String, String> data = get();
//                    shJTextField.setText(data.get("sh"));
//                    slJTextField.setText(data.get("sl"));
//
//                } catch (InterruptedException ex) {
//                    Exceptions.printStackTrace(ex);
//                } catch (ExecutionException ex) {
//                    Exceptions.printStackTrace(ex);
//                }
//
//            }
//        };
//        sw.execute();
}//GEN-LAST:event_performNodeDiscoveryJButtonActionPerformed

    private void serialPortJComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_serialPortJComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_serialPortJComboBoxPropertyChange

    private void serialPortJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_serialPortJComboBoxItemStateChanged
        // TODO add your handling code here:
        Object evtValue = evt.getItem();
        if ("No port selected".equals(evtValue)) {
            return;
        }
        //9600 bps, 8 bit, No parity, 1 stop bit and no flow control.

        speedJComboBox.removeAllItems();
        String[] possibleValues = {"9600", "19200", "38400", "57600", "115200"};
        for (String value : possibleValues) {
            speedJComboBox.insertItemAt(value, 0);
        }
        speedJComboBox.setSelectedItem("9600");
        speedJComboBox.setEnabled(true);
    }//GEN-LAST:event_serialPortJComboBoxItemStateChanged

    private void nodeDestinationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nodeDestinationJButtonActionPerformed
        SwingWorker sw = new SwingWorker<XBeeResponse, Void>() {

            @Override
            protected XBeeResponse doInBackground() throws Exception {
                try {

                    String nodeIdentifier = targetNodeIdentifierJTextField.getText();
                    List<Integer> list = new ArrayList<Integer>();
                    CharacterIterator it = new StringCharacterIterator(nodeIdentifier);
                    for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
                        list.add((int) ch);
                    }
                    int[] nodeIdentifierAsIntArray = new int[list.size()];
                    int i = 0;
                    for (Integer integer : list) {
                        nodeIdentifierAsIntArray[i] = integer;
                        i++;
                    }
                    return xbee.sendAtCommand(new AtCommand("DN", nodeIdentifierAsIntArray));
                } catch (XBeeException ex) {
                    Exceptions.printStackTrace(ex);
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    XBeeResponse o = get();
                    if (null != o) {
                        if (o instanceof AtCommandResponse) {
                            AtCommandResponse r = (AtCommandResponse) o;
                            r.getPacketBytes();
                            int[] bytes = r.getValue();
                            if (bytes.length != 10) {
                                Exceptions.printStackTrace(new RuntimeException("packet bytes aren't what I expected"));
                            }
                            byte[] data = new byte[bytes.length];
                            for (int i = 0; i < bytes.length; i++) {
                                int j = bytes[i];
                                data[i] = (byte) j;
                            }
                            byte[] shBytes = new byte[4];
                            byte[] slBytes = new byte[4];
                            System.arraycopy(data, 2, shBytes, 0, 4);
                            System.arraycopy(data, 6, slBytes, 0, 4);

                            final String address64bit = HexUtils.toHexString(shBytes).toUpperCase() + HexUtils.toHexString(slBytes).toUpperCase();
                            XBeeDevice device = new XBeeDevice() {

                                public String getNodeIdentifier() {
                                    return targetNodeIdentifierJTextField.getText();
                                }

                                public String getAddress16bit() {
                                    return "N/A";
                                }

                                public String getAddress64bit() {
                                    return address64bit;
                                }
                            };
                            instanceContent.add(device);
                        //nodesInstance.findInstance().addNode(targetNodeIdentifierJTextField.getText(), "N/A", address64bit);

                        }
                    }
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        sw.execute();
}//GEN-LAST:event_nodeDestinationJButtonActionPerformed

    private void speedJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedJComboBoxActionPerformed
        reconfigXbee();
    }//GEN-LAST:event_speedJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nodeDestinationJButton;
    private javax.swing.JButton performNodeDiscoveryJButton;
    private javax.swing.JButton rescanJButton;
    private javax.swing.JComboBox serialPortJComboBox;
    private javax.swing.JComboBox speedJComboBox;
    private javax.swing.JLabel targetNodeIdentifierJLabel;
    private javax.swing.JTextField targetNodeIdentifierJTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized XBeeTopComponent getDefault() {
        if (instance == null) {
            instance = new XBeeTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the XBeeTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized XBeeTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(XBeeTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof XBeeTopComponent) {
            return (XBeeTopComponent) win;
        }
        Logger.getLogger(XBeeTopComponent.class.getName()).warning(
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

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return XBeeTopComponent.getDefault();
        }
    }
}
