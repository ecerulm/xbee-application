/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rubenlaguna.xbeemodule;

/**
 *
 * @author ecerulm
 */
public class Utils {
    /**
     * Hex digits.
     */
    private static final char[] HEX = "0123456789ABCDEF".toCharArray();

    /**
     * Convert a byte array to a hex dump.
     *
     * This is a replacement for Text.toString(byte[] ab, int cBytesPerLine).
     *
     * @param ab             the byte array to format as a hex string
     * @param cBytesPerLine  the number of bytes to display on a line
     *
     * @return a multi-line hex dump
     */
    public static String toHexDump(byte[] ab, int cBytesPerLine) {
        int cb = ab.length;
        if (cb == 0) {
            return "";
        }

        // calculate number of digits required to show offset
        int cDigits = 0;
        int cbTemp = cb - 1;
        do {
            cDigits += 2;
            cbTemp /= 0x100;
        } while (cbTemp > 0);

        // calculate number and size of lines
        int cLines = (cb + cBytesPerLine - 1) / cBytesPerLine;
        int cCharsPerLine = cDigits + 4 * cBytesPerLine + 5;

        // pre-allocate buffer to build hex dump
        int cch = cLines * cCharsPerLine;
        char[] ach = new char[cch];

        // offsets within each line for formatting stuff
        int ofColon = cDigits;
        int ofSpc1 = ofColon + 1;
        int ofSpc2 = ofColon + 2;
        int ofSpc3 = cCharsPerLine - cBytesPerLine - 2;
        int ofLF = cCharsPerLine - 1;

        // offsets within each line for data
        int ofHexInLine = ofColon + 3;
        int ofCharInLine = ofLF - cBytesPerLine;

        int ofByte = 0;
        int ofLine = 0;
        for (int iLine = 0; iLine < cLines; ++iLine) {
            // format offset
            int nOffset = ofByte;
            int ofDigit = ofLine + cDigits;
            for (int i = 0; i < cDigits; ++i) {
                ach[--ofDigit] = HEX[nOffset & 0x0F];
                nOffset >>= 4;
            }

            // formatting
            int ofFmt = ofLine + cDigits;
            ach[ofFmt++] = ':';
            ach[ofFmt++] = ' ';
            ach[ofFmt++] = ' ';

            // format data
            int ofHex = ofLine + ofHexInLine;
            int ofChar = ofLine + ofCharInLine;
            for (int i = 0; i < cBytesPerLine; ++i) {
                try {
                    int n = ((int) ab[ofByte++]) & 0xFF;

                    ach[ofHex++] = HEX[(n & 0xF0) >> 4];
                    ach[ofHex++] = HEX[(n & 0x0F)];
                    ach[ofHex++] = ' ';
                    ach[ofChar++] = (n < 32 ? '.' : (char) n);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ach[ofHex++] = ' ';
                    ach[ofHex++] = ' ';
                    ach[ofHex++] = ' ';
                    ach[ofChar++] = ' ';
                }
            }

            // spacing and newline
            ach[ofHex] = ' ';
            ach[ofChar] = '\n';

            ofLine += cCharsPerLine;
        }

        return new String(ach, 0, cch - 1);
    }
}
