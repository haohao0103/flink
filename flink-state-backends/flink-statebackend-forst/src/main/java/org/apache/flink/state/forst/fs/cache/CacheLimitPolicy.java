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

package org.apache.flink.state.forst.fs.cache;

import org.apache.flink.metrics.MetricGroup;

/** Cache limit policy. */
public interface CacheLimitPolicy {

    /** Whether to support directly write in cache. */
    boolean directWriteInCache();

    /**
     * Whether the cache usage is safe to add.
     *
     * @param toAddSize
     * @return false if the toAddSize is larger than max available capacity, true otherwise.
     */
    boolean isSafeToAdd(long toAddSize);

    /**
     * Whether the cache usage is exceeded the upperbound.
     *
     * @param toAddSize the size about to add.
     * @param hasFile whether the file is already in cache.
     * @return true if the cache usage is overflow, false otherwise.
     */
    boolean isOverflow(long toAddSize, boolean hasFile);

    /**
     * Acquire cache.
     *
     * @param toAddSize
     */
    void acquire(long toAddSize);

    /**
     * Release cache.
     *
     * @param toReleaseSize
     */
    void release(long toReleaseSize);

    /**
     * Get current used bytes.
     *
     * @return cache bytes.
     */
    long usedBytes();

    /**
     * Register customized metrics.
     *
     * @param prefix
     * @param metricGroup
     */
    void registerCustomizedMetrics(String prefix, MetricGroup metricGroup);
}
