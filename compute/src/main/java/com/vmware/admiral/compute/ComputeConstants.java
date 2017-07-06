/*
 * Copyright (c) 2016-2017 VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices
 * and license terms. Your use of these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package com.vmware.admiral.compute;

import com.vmware.photon.controller.model.UriPaths;
import com.vmware.xenon.common.UriUtils;

public class ComputeConstants {

    public static final String HOST_AUTH_CREDENTIALS_PROP_NAME = "__authCredentialsLink";

    public static final String ENDPOINT_AUTH_CREDENTIALS_PROP_NAME = "__endpointAuthCredentialsLink";

    public static final String COMPUTE_HOST_PROP_NAME = "__computeHost";

    public static final String COMPUTE_CONTAINER_HOST_PROP_NAME = "__computeContainerHost";

    public static final String COMPUTE_CONFIG_CONTENT_PROP_NAME = "__computeConfigContent";

    public static final String GROUP_RESOURCE_PLACEMENT_LINK_NAME = "__groupResourcePlacementLink";

    /**
     * This property should be set only on container hosts of scheduler type. If set to true, the
     * placement zone that is specified in the resourcePoolLink property should be automatically
     * deleted after the host removal.
     */
    public static final String AUTOGENERATED_PLACEMENT_ZONE_PROP_NAME = "__autogeneratedPlacementZone";

    public static final String DOCKER_URI_PROP_NAME = "__dockerUri";

    public static final String FIELD_NAME_COMPOSITE_COMPONENT_LINK_KEY = "__compositeComponentLink";

    public static final String CUSTOM_PROP_ENDPOINT_TYPE_NAME = "__endpointType";

    public static final String CUSTOM_PROP_PROFILE_LINK_NAME = "__profileLink";

    public static final String CUSTOM_PROP_CLUSTER_SIZE_KEY = "clusterSize";

    public static final String CUSTOM_PROP_IMAGE_ID_NAME = "imageType";

    public static final String CUSTOM_PROP_IMAGE_REF_NAME = "imageRef";

    public static final String CUSTOM_PROP_SSH_AUTHORIZED_KEY_NAME = "sshKey";

    public static final String CUSTOM_PROP_ENABLE_SSH_ACCESS_NAME = "enableSSH";

    public static final String HOST_URI_PROP_NAME = "__hostURI";

    public static final String COMPUTE_PLACEMENT_CONSTRAINT_KEY = "placement";

    public static final String OVA_URI = "ova.uri";
    public static final String OVF_PROP_PREFIX = "ovf.prop:";
    public static final String OVF_COREOS_CLOUD_INIT_PROP = "guestinfo.coreos.config.data";

    public static final String CUSTOM_PROP_NETWORK_PROFILE_EXTENSION_DATA = "__networkProfileExtensionData";

    /**
     * A key for the custom properties property which value stores serialized to json custom
     * payload.
     */
    public static final String OPERATION_PAYLOAD_PROP_NAME = "__operationPayload";

    public enum AdapterType {
        INSTANCE_ADAPTER("instance-adapter"),
        NETWORK_ADAPTER("network-adapter"),
        FIREWALL_ADAPTER("firewall-adapter"),
        STATS_ADAPTER("stats-adapter"),
        BOOT_ADAPTER("boot-adapter"),
        POWER_ADAPTER("power-adapter"),
        ENUMERATION_ADAPTER("enumeration-adapter"),
        ENUMERATION_CREATION_ADAPTER("enumeration-creation-adapter"),
        ENUMERATION_DELETION_ADAPTER("enumeration-deletion-adapter"),
        COMPUTE_DESCRIPTION_CREATION_ADAPTER("compute-description-creation-adapter"),
        COMPUTE_STATE_CREATION_ADAPTER("compute-state-creation-adapter");

        private final String path;

        private AdapterType(String path) {
            this.path = path;
        }

        public String adapterLink(String endpointType) {
            return UriUtils.buildUriPath(UriPaths.PROVISIONING, endpointType, this.path);
        }
    }

    public enum EndpointType {
        VSPHERE_TYPE("vsphere");

        public final String type;

        private EndpointType(String type) {
            this.type = type;
        }

        public static EndpointType resolveEndpointType(String computeEndpointType) {
            if (VsphereConstants.COMPUTE_VSPHERE_TYPE.equals(computeEndpointType)) {
                return VSPHERE_TYPE;
            }

            return null;
        }
    }
}
