/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubenlaguna.xbeemodule;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import org.openide.util.Exceptions;

/**
 *
 * @author ecerulm
 */
class ReadListener extends Thread implements SerialPortEventListener {

    private InputStream inputStream;

    ReadListener(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                try {
                    byte[] readBuffer = new byte[20];

                    while (inputStream.available() > 0) {
                        int numBytes = inputStream.read(readBuffer);
                    }

                    System.out.print(Utils.toHexDump(readBuffer,16));
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
                break;
        }
    }
}
