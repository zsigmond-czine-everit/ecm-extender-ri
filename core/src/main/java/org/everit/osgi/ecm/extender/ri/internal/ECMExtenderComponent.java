/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.ecm.extender.ri.internal;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

/**
 * Component that opens {@link ECMCapabilityTracker}.
 */
public class ECMExtenderComponent {

  private LogService logService;

  private ECMCapabilityTracker tracker;

  public void activate(final BundleContext context) {
    tracker = new ECMCapabilityTracker(context, logService);
    tracker.open();
  }

  public void deactivate() {
    tracker.close();
  }

  public void setLogService(final LogService logService) {
    this.logService = logService;
  }
}
