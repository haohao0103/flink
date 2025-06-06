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

package org.apache.flink.table.planner.plan.trait;

/** Lists all kinds of {@link ModifyKind#DELETE} operation. */
public enum DeleteKind {

    /** This kind indicates that operators do not emit {@link ModifyKind#DELETE} operation. */
    NONE,

    /**
     * This kind indicates that operators can emit deletes with the key only. The rest of the row
     * may be not present.
     */
    DELETE_BY_KEY,

    /** This kind indicates that operators should emit deletes with the full row. */
    FULL_DELETE
}
