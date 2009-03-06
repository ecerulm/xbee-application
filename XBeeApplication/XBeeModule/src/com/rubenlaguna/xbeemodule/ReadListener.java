/*
 * ReadListener.java
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
