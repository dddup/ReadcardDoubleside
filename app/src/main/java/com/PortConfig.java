/*
 * Copyright 2009 Cedric Priscal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com;

import android.content.SharedPreferences;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import android_serialport_api.SerialPort;
import android_serialport_api.SerialPortFinder;

public class PortConfig {

    public SerialPortFinder mSerialPortFinder = new SerialPortFinder();

    private static SerialPort mSerialPort = null;

    public static SerialPort getSerialPort(String path, int baudrate) throws SecurityException, IOException, InvalidParameterException {
        if (mSerialPort == null) {

            if ((path.length() == 0) || (baudrate == -1)) {
                throw new InvalidParameterException();
            }

            /* Open the serial port */
            //	mSerialPort = new SerialPort(new File("/dev/ttySAC1"), 9600, 0);
            mSerialPort = new SerialPort(new File(path), baudrate, 0);
//			mSerialPort = new SerialPort(new File("/dev/ttyS1"), baudrate, 0);
        }
        return mSerialPort;
    }

    public static void closeSerialPort() {
        if (mSerialPort != null) {
            mSerialPort.close();
            mSerialPort = null;
        }
    }
}
