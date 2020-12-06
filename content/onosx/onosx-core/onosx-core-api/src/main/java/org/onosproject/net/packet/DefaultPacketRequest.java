/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.net.packet;

import com.google.common.base.MoreObjects;

import org.onosproject.cluster.NodeId;
import org.onosproject.core.ApplicationId;
import org.onosproject.net.flow.TrafficSelector;

import java.util.Objects;

/**
 * Default implementation of a packet request.
 */
public final class DefaultPacketRequest implements PacketRequest {
    private final TrafficSelector selector;
    private final PacketPriority priority;
    private final ApplicationId appId;
    private final NodeId nodeId;

    /**
     * Creates a new packet request.
     *
     * @param selector  traffic selector
     * @param priority  intercept priority
     * @param appId     application id
     * @param nodeId    identifier of node where request originated
     */
    public DefaultPacketRequest(TrafficSelector selector, PacketPriority priority,
                                ApplicationId appId,
                                NodeId nodeId) {
        this.selector = selector;
        this.priority = priority;
        this.appId = appId;
        this.nodeId = nodeId;
    }

    @Override
    public TrafficSelector selector() {
        return selector;
    }

    @Override
    public PacketPriority priority() {
        return priority;
    }

    @Override
    public ApplicationId appId() {
        return appId;
    }

    @Override
    public NodeId nodeId() {
        return nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(selector, priority, appId, nodeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DefaultPacketRequest other = (DefaultPacketRequest) obj;
        return Objects.equals(this.selector, other.selector)
                && Objects.equals(this.priority, other.priority)
                && Objects.equals(this.appId, other.appId)
                && Objects.equals(this.nodeId, other.nodeId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("selector", selector)
                .add("priority", priority)
                .add("appId", appId)
                .add("nodeId", nodeId).toString();
    }
}