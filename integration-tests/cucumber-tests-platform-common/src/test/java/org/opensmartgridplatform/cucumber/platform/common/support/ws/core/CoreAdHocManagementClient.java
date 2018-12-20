/**
 * Copyright 2016 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.opensmartgridplatform.cucumber.platform.common.support.ws.core;

import org.opensmartgridplatform.adapter.ws.schema.core.adhocmanagement.SetRebootAsyncRequest;
import org.opensmartgridplatform.adapter.ws.schema.core.adhocmanagement.SetRebootAsyncResponse;
import org.opensmartgridplatform.adapter.ws.schema.core.adhocmanagement.SetRebootRequest;
import org.opensmartgridplatform.adapter.ws.schema.core.adhocmanagement.SetRebootResponse;
import org.opensmartgridplatform.cucumber.platform.support.ws.BaseClient;
import org.opensmartgridplatform.shared.exceptionhandling.WebServiceSecurityException;
import org.opensmartgridplatform.shared.infra.ws.DefaultWebServiceTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class CoreAdHocManagementClient extends BaseClient {

    @Autowired
    private DefaultWebServiceTemplateFactory coreAdHocManagementWstf;

    public SetRebootAsyncResponse setReboot(final SetRebootRequest request) throws WebServiceSecurityException {
        final WebServiceTemplate webServiceTemplate = this.coreAdHocManagementWstf
                .getTemplate(this.getOrganizationIdentification(), this.getUserName());
        return (SetRebootAsyncResponse) webServiceTemplate.marshalSendAndReceive(request);
    }

    public SetRebootResponse getSetRebootResponse(final SetRebootAsyncRequest request)
            throws WebServiceSecurityException {
        final WebServiceTemplate webServiceTemplate = this.coreAdHocManagementWstf
                .getTemplate(this.getOrganizationIdentification(), this.getUserName());
        return (SetRebootResponse) webServiceTemplate.marshalSendAndReceive(request);
    }
}
