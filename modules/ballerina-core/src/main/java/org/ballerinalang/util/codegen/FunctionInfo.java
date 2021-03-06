/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.util.codegen;

import org.ballerinalang.natives.AbstractNativeFunction;

import java.util.Objects;

/**
 * {@code FunctionInfo} contains metadata of a Ballerina function entry in the program file.
 *
 * @since 0.87
 */
public class FunctionInfo extends CallableUnitInfo {

    private AbstractNativeFunction nativeFunction;

    public FunctionInfo(String pkgPath, int pkgCPIndex, String funcName, int funcNameCPIndex) {
        this.pkgPath = pkgPath;
        this.pkgCPIndex = pkgCPIndex;
        this.name = funcName;
        this.nameCPIndex = funcNameCPIndex;

        codeAttributeInfo = new CodeAttributeInfo();
        attributeInfoMap.put(AttributeInfo.CODE_ATTRIBUTE, codeAttributeInfo);
    }

    public AbstractNativeFunction getNativeFunction() {
        return nativeFunction;
    }

    public void setNativeFunction(AbstractNativeFunction nativeFunction) {
        this.nativeFunction = nativeFunction;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pkgCPIndex, nameCPIndex);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FunctionInfo && pkgCPIndex == (((FunctionInfo) obj).pkgCPIndex)
                && nameCPIndex == (((FunctionInfo) obj).nameCPIndex);
    }
}
