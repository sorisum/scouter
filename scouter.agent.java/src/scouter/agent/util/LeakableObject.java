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
package scouter.agent.util;

public class LeakableObject {

	public LeakTracer parent;
	public int pidx;

	public LeakData info;
	
	public LeakableObject(Error error, String inner, int service, long txid, boolean fullstack) {
		LeakTracer.add(this);
		this.info=new LeakData(error, inner, service, txid, fullstack);
	}

	public void close() {
		parent.bucket[pidx] = null;
	}
}