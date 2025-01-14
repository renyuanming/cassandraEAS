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

import java.util.List;

import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.ReadResponse;
import org.apache.cassandra.schema.TableMetadata;


public class DoubleTreasTag
{
    private Long quorumMaxTreasTag = null;
    private Long recoverMaxTreasTag = null;
    private List<String> codes = null;
    private ReadResponse readResponse;
    private String readResult;
    private boolean needWriteBack = true;

    private DecoratedKey key;
    private TableMetadata tableMetadata;
    private String keySpace;

    public boolean isNeedWriteBack()
    {
        return needWriteBack;
    }

    public void setNeedWriteBack(boolean needWriteBack)
    {
        this.needWriteBack = needWriteBack;
    }

    public String getReadResult () {
        return this.readResult;
    }

    public void setReadResult(String readResult) {
        this.readResult = readResult;
    }

    public Long getQuorumMaxTreasTag()
    {
        return quorumMaxTreasTag;
    }

    public void setQuorumMaxTreasTag(Long quorumMaxTreasTag)
    {
        this.quorumMaxTreasTag = quorumMaxTreasTag;
    }

    public Long getRecoverMaxTreasTag()
    {
        return recoverMaxTreasTag;
    }

    public void setRecoverMaxTreasTag(Long recoverMaxTreasTag)
    {
        this.recoverMaxTreasTag = recoverMaxTreasTag;
    }

    public List<String> getCodes()
    {
        return codes;
    }

    public void setCodes(List<String> codes)
    {
        this.codes = codes;
    }

    public DecoratedKey getKey()
    {
        return key;
    }

    public void setKey(DecoratedKey key)
    {
        this.key = key;
    }

    public TableMetadata getTableMetadata()
    {
        return tableMetadata;
    }

    public void setTableMetadata(TableMetadata tableMetadata)
    {
        this.tableMetadata = tableMetadata;
    }

    public String getKeySpace()
    {
        return keySpace;
    }

    public void setKeySpace(String keySpace)
    {
        this.keySpace = keySpace;
    }

    public ReadResponse getReadResponse()
    {
        return readResponse;
    }

    public void setReadResponse(ReadResponse readResponse)
    {
        this.readResponse = readResponse;
    }
}
