/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.forsrc.interceptor;

import com.forsrc.utils.WebUtils;
/*import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;*/

import javax.servlet.http.HttpServletRequest;

/**
 * The type Change language interceptor.
 */
public class ChangeLanguageInterceptor
        //extends AbstractInterceptor
{

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = -8692011752175474388L;

    /*@Override
    public String intercept(ActionInvocation invocation) throws Exception {

        HttpServletRequest request = (HttpServletRequest) invocation
                .getInvocationContext().get(ServletActionContext.HTTP_REQUEST);

        WebUtils.setLanguage(request);

        return invocation.invoke();
    }*/

}
