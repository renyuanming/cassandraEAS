/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.Treas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.cassandra.utils.FBUtilities;

public class Logger
{
    private Object obj1 = new Object();
    private Object obj2 = new Object();


    private static Logger logger = new Logger();

    public static Logger getLogger() {
        return logger;
    }

    private final String absPath = "/root/cassandra/logs/";

    private  void initFile(String name){
        File file = new File(name);
        try
        {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void writeMutateStats(long num, String value, String key) {
        synchronized (obj1) {
            int index = TreasConfig.getAddressMap().get(FBUtilities.getJustLocalAddress().toString().substring(1));
            String name = absPath + "muateStats" + index + ".txt";
            FileWriter writer = null;
            try
            {
                initFile(name);
                writer = new FileWriter(name,true);
            } catch  (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter printWriter = new BufferedWriter (writer);
            try {
                printWriter.write(num +  " ");
                printWriter.write(value +  ' ');
                printWriter.write(key + ' ');
                printWriter.newLine();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeReadStats(long num, String value, String key) {
        synchronized (obj2) {
            int index = TreasConfig.getAddressMap().get(FBUtilities.getJustLocalAddress().toString().substring(1));
            String name = absPath + "readStats" + index + ".txt";
            FileWriter writer = null;
            try
            {
                initFile(name);
                writer = new FileWriter(name,true);
            } catch  (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter printWriter = new BufferedWriter (writer);
            try {
                printWriter.write(num + " ");
                printWriter.write(value + ' ');
                printWriter.write(key + ' ');
                printWriter.newLine();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
