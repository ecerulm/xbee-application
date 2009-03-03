/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubenlaguna.xbeemodule;

/**
 *
 * @author ecerulm
 */
public interface XBeeDevice {

    String getNodeIdentifier();

    String getAddress16bit();

    String getAddress64bit();
}
