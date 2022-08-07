package com.alibaba.ageiport.processor.core.task.event;

import com.alibaba.ageiport.processor.core.AgeiPort;
import com.alibaba.ageiport.processor.core.spi.publisher.ManageablePublisher;
import com.alibaba.ageiport.processor.core.spi.publisher.PublishPayload;

/**
 * @author lingyi
 */
public class WaitDispatchMainTaskPrepareEventPublisher implements ManageablePublisher<WaitDispatchMainTaskPrepareEvent> {

    private AgeiPort ageiPort;

    @Override
    public void startPublish(AgeiPort ageiPort) {
        this.ageiPort = ageiPort;
    }

    @Override
    public void publish(PublishPayload payload) {
        this.ageiPort.getLocalEventBus().post(new WaitDispatchMainTaskPrepareEvent(payload.getMainTaskId()));
    }

    @Override
    public Class<WaitDispatchMainTaskPrepareEvent> publishEventType() {
        return WaitDispatchMainTaskPrepareEvent.class;
    }
}
