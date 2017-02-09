/*
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices
 * and license terms. Your use of these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package com.vmware.admiral.compute.content.compose;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Common YAML description for Docker Compose / Composite Template content
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonDescriptionEntity {
    public String version;
    public Map<String, Object> services; // if Docker Compose version 2
    public Map<String, Object> components; // if Composite Template
    public String apiVersion; // if Kubernetes
    public String kind; // if Kubernetes
}
