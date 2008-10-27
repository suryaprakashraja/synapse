/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.synapse.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Local repository for holds Task descriptions
 */
public class TaskDescriptionRepository {

    private static final Log log = LogFactory.getLog(TaskDescriptionRepository.class);
    private final Map<String, TaskDescription> taskDescriptionMap = new HashMap<String, TaskDescription>();

    public void addTaskDescription(TaskDescription taskDescription) {
        validateTaskDescription(taskDescription);

        String name = taskDescription.getName();
        validateName(name);
        validateUniqueness(name);

        taskDescriptionMap.put(name, taskDescription);

    }

    public TaskDescription getTaskDescription(String name) {
        validateName(name);
        return taskDescriptionMap.get(name);
    }

    public boolean isUnique(String name) {
        return taskDescriptionMap.isEmpty() || !taskDescriptionMap.containsKey(name);
    }


    private void validateName(String name) {
        if (name == null || "".equals(name)) {
            throw new SynapseTaskException("Task name is null or empty", log);
        }

    }

    private void validateUniqueness(String name) {
        if (taskDescriptionMap.containsKey(name)) {
            throw new SynapseTaskException("Name with ' " + name + " ' is already there", log);
        }
    }

    private void validateTaskDescription(TaskDescription taskDescription) {
        if (taskDescription == null) {
            throw new SynapseTaskException("TaskDescription is null", log);
        }

    }
}
